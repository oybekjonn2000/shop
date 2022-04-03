package net.idrok.shopping.security;

import net.idrok.shopping.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserSpecial implements UserDetails {

    private String username;
    private String password;
    private Set<GrantedAuthority> authority;
    private boolean enabled;

    public UserSpecial(User user){
        this.username = user.getLogin();
        this.password = user.getPassword();
        this.authority = new HashSet<>();
        this.authority.add(new SimpleGrantedAuthority(user.getRole().toString()));
        this.enabled  = user.isActive();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authority;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
