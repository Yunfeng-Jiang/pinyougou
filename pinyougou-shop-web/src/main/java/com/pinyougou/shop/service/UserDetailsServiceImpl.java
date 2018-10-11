package com.pinyougou.shop.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.stereotype.Service;

/**
 * 认证类
 * @author Administrator
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private SellerService sellerService;

	/**
	 * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色.
     * 因为资源是不变的，而用户的角色是会变的
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("~~~~~~~~经过了loadUserByUsername~~~~~~~~~");
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // ROLE_SELLER 表示权限角色,该处属于商户角色,可以自定义,比如ROLE_XXX,但必须以'ROLE_'开头
        authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        //得到商家对象
        TbSeller seller = sellerService.findOne(username);
        if (seller == null) {
            return null;
        } else {
            if(seller.getStatus().equals("1")){
                return new User(username,seller.getPassword(),authorities);
            }else{
                return null;
            }
        }
    }

}
