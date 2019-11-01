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

	public static List<RelatedParty> addUser(String username, UserPartRoleType prt,  @Valid List<RelatedParty> relatedParty) {
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
			rp.setName(username);
			rp.setRole(prt.toString());
			rp.setReferredType("SimpleUsername_Individual");
			rpRes.add(rp);
		}

		return rpRes;
	}

}
