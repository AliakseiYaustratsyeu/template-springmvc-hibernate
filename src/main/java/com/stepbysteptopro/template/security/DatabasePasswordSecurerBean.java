package com.stepbysteptopro.template.security;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class DatabasePasswordSecurerBean extends JdbcDaoSupport {

    private PasswordEncoder passwordEncoder;
    private SaltSource saltSource;
    private UserDetailsService userDetailsService;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setSaltSource(SaltSource saltSource) {
        this.saltSource = saltSource;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public void secureDatabase() {

        logger.debug("<<<< DatabasePasswordSecurerBean is running!!! >>>>>");

        getJdbcTemplate().query("select username, password, password_encrypted from r_user", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                String username = rs.getString(1);
                String password = rs.getString(2);
                boolean passwordEncrypted = rs.getBoolean(3);

                UserDetails user = userDetailsService.loadUserByUsername(username);
                String encodedPassword = passwordEncoder.encodePassword(password, saltSource.getSalt(user));

                if (encodedPassword != null && !encodedPassword.equals(password) && !passwordEncrypted) {
                    getJdbcTemplate().update(
                            "update r_user set password = ?, password_encrypted = ? where username = ?",
                            encodedPassword, Boolean.TRUE, username);
                    logger.debug("Updating password for username:" + username + " to: " + encodedPassword);
                }

            }
        });
    }
}
