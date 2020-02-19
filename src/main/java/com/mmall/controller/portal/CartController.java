package com.mmall.controller.portal;

import com.mmall.common.Const;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.ICartService;
import com.mmall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/cart/")
public class CartController {

    @Autowired
    private ICartService iCartService;

    /**
      * @Author Yangh
      * @Description //TODO 查询购物车集合接口
      * @Date 2020/2/18 15:49
      * @param session
      * @return com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
    **/
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<CartVo> list(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.list(user.getId());
    }

    /**
      * @Author Yangh
      * @Description //TODO 加入购物车接口
      * @Date 2020/2/16 22:22
      * @param session
      * @param count
      * @param productId
      * @return com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
    **/
    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse<CartVo> add(HttpSession session, Integer count, Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.add(user.getId(),productId,count);
    }

    /**
      * @Author Yangh
      * @Description //TODO 更新购物车接口
      * @Date 2020/2/18 15:00
      * @param session
      * @param count
      * @param productId
      * @return com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
    **/
    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse<CartVo> update(HttpSession session, Integer count, Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.update(user.getId(),productId,count);
    }

    /**
      * @Author Yangh
      * @Description //TODO 删除购物车中产品接口
      * @Date 2020/2/18 15:32
      * @param session
      * @param productIds
      * @return com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
    **/
    @RequestMapping("delete_product.do")
    @ResponseBody
    public ServerResponse<CartVo> deleteProduct(HttpSession session,String productIds){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.deleteProduct(user.getId(),productIds);
    }


    /**
      * @Author Yangh
      * @Description //TODO 全选接口
      * @Date 2020/2/18 15:58
      * @param session
      * @return com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
    **/
    @RequestMapping("select_all.do")
    @ResponseBody
    public ServerResponse<CartVo> selectAll(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),null,Const.Cart.CHECKED);
    }

    /**
      * @Author Yangh
      * @Description //TODO 全返现接口
      * @Date 2020/2/18 15:58
      * @param session
      * @return com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
    **/
    @RequestMapping("un_select_all.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelectAll(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),null,Const.Cart.UN_CHECKED);
    }

    /**
      * @Author Yangh
      * @Description //TODO 单独选接口
      * @Date 2020/2/18 16:02
      * @param session
      * @param productId
      * @return com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
    **/
    @RequestMapping("select.do")
    @ResponseBody
    public ServerResponse<CartVo> select(HttpSession session,Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),productId,Const.Cart.CHECKED);
    }

    /**
      * @Author Yangh
      * @Description //TODO 单独反选接口
      * @Date 2020/2/18 16:02
      * @param session
      * @param productId
      * @return com.mmall.common.ServerResponse<com.mmall.vo.CartVo>
    **/
    @RequestMapping("un_select.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelect(HttpSession session,Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),productId,Const.Cart.UN_CHECKED);
    }

    /**
      * @Author Yangh
      * @Description //TODO 查询当前用户的购物车里面的产品数量接口。如果一个产品有10个,那么数量就是10.
      * @Date 2020/2/18 16:13
      * @param session
      * @return com.mmall.common.ServerResponse<java.lang.Integer>
    **/
    @RequestMapping("get_cart_product_count.do")
    @ResponseBody
    public ServerResponse<Integer> getCartProductCount(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user ==null){
            return ServerResponse.createBySuccess(0);
        }
        return iCartService.getCartProductCount(user.getId());
    }

}
