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
package io.openslice.tmf.pcm620.reposervices;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.common.model.Attachment;
import io.openslice.tmf.pcm620.repo.AttachmentRepository;


@Service
public class AttachmentRepoService {


	@Autowired
	AttachmentRepository attachmentRepo;
	
	public Attachment addAttachment(Attachment c) {

		return this.attachmentRepo.save(c);
	}

	public Attachment updateAttachment(@Valid Attachment attachment) {
		return this.attachmentRepo.save( attachment );
	}

	public Attachment findByUuid(String attid) {
		Optional<Attachment> ret = this.attachmentRepo.findByUuid(attid);
		return ret.orElse(null);
		
	}
}
