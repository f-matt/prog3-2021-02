package br.edu.facthus.config;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

import br.edu.facthus.util.CustomPasswordHash;

@CustomFormAuthenticationMechanismDefinition(
		loginToContinue = @LoginToContinue(
				loginPage = "/login.jsf",
				errorPage = "/login.jsf?error=true",
				useForwardToLogin = false)
)
@DatabaseIdentityStoreDefinition(
		dataSourceLookup = "java:/authDS",
		callerQuery = "SELECT password "
				+ "FROM users "
				+ "WHERE login = ?",
		groupsQuery = "SELECT g.\"group\" "
				+ "FROM groups g "
				+ "JOIN users_groups ug ON g.id = ug.group_id "
				+ "JOIN users u ON u.id = ug.user_id "
				+ "WHERE u.login = ?",
		hashAlgorithm = CustomPasswordHash.class)
@ApplicationScoped
@FacesConfig
public class ApplicationConfig {

}
