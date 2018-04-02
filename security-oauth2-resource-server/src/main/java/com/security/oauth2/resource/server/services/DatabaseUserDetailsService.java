package com.security.oauth2.resource.server.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Service
public class DatabaseUserDetailsService implements UserDetailsService {

	// @Autowired
	// private UserRepository userRepository; // In case there's a database

	@Override
	public UserDetails loadUserByUsername(String username) {
		//User user = userRepository.findByUsername(username); // In case there's a database
		User user = new User();
		user.setId(1L);
		user.setUsername(username);
		/*if (user == null) {
			throw new UsernameNotFoundException(username);
		}*/
		return new ResourceServerUserDetails(user);
	}

	@Data
	private static class User {
		private Long Id;
		private String username;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	private static class ResourceServerUserDetails implements UserDetails {
		
		private static final long serialVersionUID = 798630270959315536L;
		private User user;

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return null;
		}
		@Override
		public String getPassword() {
			return null;
		}
		@Override
		public String getUsername() {
			return this.user.getUsername();
		}
		@Override
		public boolean isAccountNonExpired() {
			return false;
		}
		@Override
		public boolean isAccountNonLocked() {
			return false;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			return false;
		}
		@Override
		public boolean isEnabled() {
			return true;
		}
	}

}
