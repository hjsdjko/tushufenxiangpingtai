
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 图书借阅
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tushuOrder")
public class TushuOrderController {
    private static final Logger logger = LoggerFactory.getLogger(TushuOrderController.class);

    private static final String TABLE_NAME = "tushuOrder";

    @Autowired
    private TushuOrderService tushuOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private TushuService tushuService;//图书
    @Autowired
    private TushuCollectionService tushuCollectionService;//图书收藏
    @Autowired
    private TushuCommentbackService tushuCommentbackService;//图书评价
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = tushuOrderService.queryPage(params);

        //字典表数据转换
        List<TushuOrderView> list =(List<TushuOrderView>)page.getList();
        for(TushuOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TushuOrderEntity tushuOrder = tushuOrderService.selectById(id);
        if(tushuOrder !=null){
            //entity转view
            TushuOrderView view = new TushuOrderView();
            BeanUtils.copyProperties( tushuOrder , view );//把实体数据重构到view中
            //级联表 收货地址
            //级联表
            AddressEntity address = addressService.selectById(tushuOrder.getAddressId());
            if(address != null){
            BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setAddressId(address.getId());
            }
            //级联表 图书
            //级联表
            TushuEntity tushu = tushuService.selectById(tushuOrder.getTushuId());
            if(tushu != null){
            BeanUtils.copyProperties( tushu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setTushuId(tushu.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(tushuOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TushuOrderEntity tushuOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tushuOrder:{}",this.getClass().getName(),tushuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            tushuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        tushuOrder.setCreateTime(new Date());
        tushuOrder.setInsertTime(new Date());
        tushuOrderService.insert(tushuOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TushuOrderEntity tushuOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tushuOrder:{}",this.getClass().getName(),tushuOrder.toString());
        TushuOrderEntity oldTushuOrderEntity = tushuOrderService.selectById(tushuOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            tushuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            tushuOrderService.updateById(tushuOrder);//根据id更新
            return R.ok();
    }


    /**
    * 审核  同意借阅
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody TushuOrderEntity tushuOrderEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,tushuOrderEntity:{}",this.getClass().getName(),tushuOrderEntity.toString());

        TushuOrderEntity oldTushuOrder = tushuOrderService.selectById(tushuOrderEntity.getId());//查询原先数据

        if(tushuOrderEntity.getTushuOrderYesnoTypes() == 2){//通过
            tushuOrderEntity.setTushuOrderTypes(103);

            TushuEntity tushuEntity = tushuService.selectById(oldTushuOrder.getTushuId());
            if(tushuEntity == null)
                return R.error("查不到图书");
            if(tushuEntity.getTushuZhuangtaiTypes()!=1)
                return R.error("图书已被借阅");
            tushuEntity.setTushuZhuangtaiTypes(2);
            tushuService.updateById(tushuEntity);

        }else if(tushuOrderEntity.getTushuOrderYesnoTypes() == 3){//拒绝
            tushuOrderEntity.setTushuOrderTypes(106);
        }
        tushuOrderEntity.setTushuOrderShenheTime(new Date());//审核时间
        tushuOrderService.updateById(tushuOrderEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TushuOrderEntity> oldTushuOrderList =tushuOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        tushuOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<TushuOrderEntity> tushuOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            TushuOrderEntity tushuOrderEntity = new TushuOrderEntity();
//                            tushuOrderEntity.setTushuOrderUuidNumber(data.get(0));                    //借阅编号 要改的
//                            tushuOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收货地址 要改的
//                            tushuOrderEntity.setTushuId(Integer.valueOf(data.get(0)));   //图书 要改的
//                            tushuOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            tushuOrderEntity.setTushuOrderTime(sdf.parse(data.get(0)));          //预计归还时间 要改的
//                            tushuOrderEntity.setTushuOrderCourierName(data.get(0));                    //快递公司 要改的
//                            tushuOrderEntity.setTushuOrderCourierNumber(data.get(0));                    //快递单号 要改的
//                            tushuOrderEntity.setTushuOrderTypes(Integer.valueOf(data.get(0)));   //借阅类型 要改的
//                            tushuOrderEntity.setInsertTime(date);//时间
//                            tushuOrderEntity.setTushuOrderYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            tushuOrderEntity.setTushuOrderYesnoText(data.get(0));                    //回复 要改的
//                            tushuOrderEntity.setTushuOrderShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            tushuOrderEntity.setCreateTime(date);//时间
                            tushuOrderList.add(tushuOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //借阅编号
                                if(seachFields.containsKey("tushuOrderUuidNumber")){
                                    List<String> tushuOrderUuidNumber = seachFields.get("tushuOrderUuidNumber");
                                    tushuOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> tushuOrderUuidNumber = new ArrayList<>();
                                    tushuOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("tushuOrderUuidNumber",tushuOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //借阅编号
                        List<TushuOrderEntity> tushuOrderEntities_tushuOrderUuidNumber = tushuOrderService.selectList(new EntityWrapper<TushuOrderEntity>().in("tushu_order_uuid_number", seachFields.get("tushuOrderUuidNumber")));
                        if(tushuOrderEntities_tushuOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TushuOrderEntity s:tushuOrderEntities_tushuOrderUuidNumber){
                                repeatFields.add(s.getTushuOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [借阅编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        tushuOrderService.insertBatch(tushuOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = tushuOrderService.queryPage(params);

        //字典表数据转换
        List<TushuOrderView> list =(List<TushuOrderView>)page.getList();
        for(TushuOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TushuOrderEntity tushuOrder = tushuOrderService.selectById(id);
            if(tushuOrder !=null){


                //entity转view
                TushuOrderView view = new TushuOrderView();
                BeanUtils.copyProperties( tushuOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(tushuOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    TushuEntity tushu = tushuService.selectById(tushuOrder.getTushuId());
                if(tushu != null){
                    BeanUtils.copyProperties( tushu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTushuId(tushu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(tushuOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody TushuOrderEntity tushuOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tushuOrder:{}",this.getClass().getName(),tushuOrder.toString());
            TushuEntity tushuEntity = tushuService.selectById(tushuOrder.getTushuId());
            if(tushuEntity == null){
                return R.error(511,"查不到该图书");
            }
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            tushuOrder.setTushuOrderTypes(101); //设置借阅状态为已申请借阅
            tushuOrder.setTushuOrderYesnoTypes(1);
            tushuOrder.setYonghuId(userId); //设置借阅支付人id
            tushuOrder.setTushuOrderUuidNumber(String.valueOf(new Date().getTime()));
            tushuOrder.setInsertTime(new Date());
            tushuOrder.setCreateTime(new Date());
                tushuOrderService.insert(tushuOrder);//新增借阅


            return R.ok();
    }


    /**
    * 取消借阅
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            TushuOrderEntity tushuOrder = tushuOrderService.selectById(id);//当前表service
            Integer tushuId = tushuOrder.getTushuId();
            if(tushuId == null)
                return R.error(511,"查不到该图书");
            TushuEntity tushuEntity = tushuService.selectById(tushuId);
            if(tushuEntity == null)
                return R.error(511,"查不到该图书");




            tushuOrder.setTushuOrderTypes(102);//设置借阅状态为已取消借阅
            tushuOrderService.updateById(tushuOrder);//根据id更新
            tushuService.updateById(tushuEntity);//更新借阅中图书的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer tushuCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            TushuOrderEntity tushuOrder = tushuOrderService.selectById(id);
        if(tushuOrder == null)
            return R.error(511,"查不到该借阅");
        Integer tushuId = tushuOrder.getTushuId();
        if(tushuId == null)
            return R.error(511,"查不到该图书");

        TushuCommentbackEntity tushuCommentbackEntity = new TushuCommentbackEntity();
            tushuCommentbackEntity.setId(id);
            tushuCommentbackEntity.setTushuId(tushuId);
            tushuCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            tushuCommentbackEntity.setTushuCommentbackText(commentbackText);
            tushuCommentbackEntity.setInsertTime(new Date());
            tushuCommentbackEntity.setReplyText(null);
            tushuCommentbackEntity.setUpdateTime(null);
            tushuCommentbackEntity.setCreateTime(new Date());
            tushuCommentbackService.insert(tushuCommentbackEntity);

            tushuOrder.setTushuOrderTypes(105);//设置借阅状态为已评价
            tushuOrderService.updateById(tushuOrder);//根据id更新
            return R.ok();
    }

    /**
     * 借阅
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ,String tushuOrderCourierNumber, String tushuOrderCourierName , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        TushuOrderEntity  tushuOrderEntity = tushuOrderService.selectById(id);
        tushuOrderEntity.setTushuOrderTypes(103);//设置借阅状态为已借阅
        tushuOrderEntity.setTushuOrderCourierNumber(tushuOrderCourierNumber);
        tushuOrderEntity.setTushuOrderCourierName(tushuOrderCourierName);
        tushuOrderService.updateById( tushuOrderEntity);

        return R.ok();
    }


    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        TushuOrderEntity  tushuOrderEntity = tushuOrderService.selectById(id);
        tushuOrderEntity.setTushuOrderTypes(104);//设置借阅状态为收货
        tushuOrderService.updateById( tushuOrderEntity);
        return R.ok();
    }

    /**
     * 归还书籍
     */
    @RequestMapping("/guihuan")
    public R guihuan(Integer id , HttpServletRequest request){
        logger.debug("guihuan:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        TushuOrderEntity  tushuOrderEntity = tushuOrderService.selectById(id);
        tushuOrderEntity.setTushuOrderTypes(107);//设置借阅状态为已归还
        tushuOrderService.updateById( tushuOrderEntity);

        TushuEntity tushuEntity = tushuService.selectById(tushuOrderEntity.getTushuId());
        if(tushuEntity == null)
            return R.error("查不到图书");

        tushuEntity.setTushuZhuangtaiTypes(1);
        tushuService.updateById(tushuEntity);

        return R.ok();
    }

}

