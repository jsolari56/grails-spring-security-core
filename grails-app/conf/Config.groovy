// for testing only, not included in plugin zip

import org.springframework.security.authentication.AccountExpiredException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException

grails {
	plugin {
		springsecurity {
			userLookup {
				userDomainClassName = 'test.TestUser'
				usernamePropertyName = 'loginName'
				enabledPropertyName = 'enabld'
				passwordPropertyName = 'passwrrd'
				authoritiesPropertyName = 'roles'
				authorityJoinClassName = 'test.TestUserRole'
			}

			requestMap {
				className = 'test.TestRequestmap'
				urlField = 'urlPattern'
				configAttributeField = 'rolePattern'
				httpMethodField = 'httpMethod'
			}

			authority {
				className = 'test.TestRole'
				nameField = 'auth'
			}

			rememberMe {
				persistentToken {
					domainClassName = 'test.TestPersistentLogin'
				}
			}

			failureHandler {
				exceptionMappings = [
					(LockedException.name): '/testUser/accountLocked',
					(DisabledException.name): '/testUser/accountDisabled',
					(AccountExpiredException.name): '/testUser/accountExpired',
					(CredentialsExpiredException.name): '/testUser/passwordExpired'
				]
			}
		}
	}
}

grails.doc.authors = 'Burt Beckwith, Beverley Talbott'
grails.doc.license = 'Apache License 2.0'
grails.doc.title = 'Spring Security Core Plugin'
//grails.doc.subtitle = ''
//grails.doc.copyright = ''
//grails.doc.footer = ''

// Uncomment and edit the following lines to start using Grails encoding & escaping improvements

/* remove this line 
// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside null
                scriptlet = 'none' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
remove this line */
