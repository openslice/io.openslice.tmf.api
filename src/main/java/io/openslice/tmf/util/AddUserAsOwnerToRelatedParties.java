/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
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
package io.openslice.tmf.util;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.prm669.model.RelatedParty;

/**
 * 
 * this class just has method to get a prtyrole
 * 
 * @author ctranoris
 *
 */
public class AddUserAsOwnerToRelatedParties {

	public static List<RelatedParty> addUser(String username, String userid,
			UserPartRoleType prt, 
			String extendedInfo,
			@Valid List<RelatedParty> relatedParty) {
		List<RelatedParty> rpRes;
		
		if (relatedParty!=null) {
			rpRes = relatedParty;			
		} else {
			rpRes =  new ArrayList<RelatedParty>();
		}
		
		
		boolean nameFound = false;
		for (RelatedParty relatedParty2 : rpRes) {
			if (relatedParty2.getName().equals(username)
					&& relatedParty2.getRole().equals( prt.toString())) {
				nameFound = true;
				break;
			}
		}

		if (!nameFound) {
			RelatedParty rp = new RelatedParty();
			rp.setId( userid );
			rp.setName(username);
			rp.setRole(prt.toString());
			rp.setReferredType("SimpleUsername_Individual");
			rp.setExtendedInfo(extendedInfo);
			rpRes.add(rp);
		}

		return rpRes;
	}

}
