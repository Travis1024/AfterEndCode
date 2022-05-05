package com.graduation.server.config.security;


import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * description: (JwtToken工具类)
 *
 * @author : [travis-wei]
 * @version : [v1.0]
 * @createTime : [2022/1/24 16:40]
 */
@Component
public class JwtTokenUtils {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    /*jwt密钥*/
    @Value("${jwt.secret}")
    private String secret;
    /*失效时间*/
    @Value("${jwt.expiration}")
    private Long expiration;


    /**
     * 根据用户信息生成token =======================================
     *
     * @param userDetails
     * @return java.lang.String
     * @author travis-wei
     * @createTime 2022/1/24
     **/

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 从token中获取登陆用户名======================================
     *
     * @param token
     * @return java.lang.String
     * @author travis-wei
     * @createTime 2022/1/24
     **/

    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    
    /**
     * 验证token是否有效===========================================
     * 
     * @author travis-wei
     * @createTime 2022/1/24
     * @param token	
     * @param userDetails
     * @return boolean
     **/
    
    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername())&&!isTokenExpired(token);
    }

    /**
     * 判断token是否可以被刷新=======================================
     *
     * @author travis-wei
     * @createTime 2022/1/24
     * @param token
     * @return boolean
     **/

    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
     * 刷新token===================================================
     *
     * @author travis-wei
     * @createTime 2022/1/24
     * @param token
     * @return java.lang.String
     **/

    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }

    /**
     * 判断token是否失效
     *
     * @author travis-wei
     * @createTime 2022/1/24
     * @param token
     * @return boolean
     **/

    private boolean isTokenExpired(String token) {
        Date expireDate=getExpiredDateFromToken(token);
        return expireDate.before(new Date());
    }

    /**
     * 从token中获取过期时间
     *
     * @author travis-wei
     * @createTime 2022/1/24
     * @param token
     * @return java.util.Date
     **/

    private Date getExpiredDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 从token中获取荷载
     *
     * @param token
     * @return io.jsonwebtoken.Claims
     * @author travis-wei
     * @createTime 2022/1/24
     **/

    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 根据荷载生成JWT Token
     *
     * @param claims
     * @return java.lang.String
     * @author travis-wei
     * @createTime 2022/1/24
     **/

    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成Token失效时间
     *
     * @return java.util.Date
     * @author travis-wei
     * @createTime 2022/1/24
     **/

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }


}
