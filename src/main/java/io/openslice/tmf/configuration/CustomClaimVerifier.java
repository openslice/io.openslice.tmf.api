/*-
 * ========================LICENSE_START=================================
 * io.openslice.portal.api
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.configuration;

public class CustomClaimVerifier {
	
}


//import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
//import org.springframework.security.oauth2.provider.token.store.JwtClaimsSetVerifier;
//
//public class CustomClaimVerifier implements JwtClaimsSetVerifier {
//    @Override
//    public void verify(Map<String, Object> claims) throws InvalidTokenException {
//        final String username = (String) claims.get("user_name");
//        if ((username == null) || (username.length() == 0)) {
//            throw new InvalidTokenException("user_name claim is empty");
//        }
//    }
//}
