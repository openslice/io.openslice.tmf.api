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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ctranoris
 *
 */
public class AttachmentUtil {




	/**
	 * @param att
	 * @param filePath
	 * @return
	 */
	public static String saveFile(MultipartFile att, String filePath) {
		File file = new File(filePath + att.getOriginalFilename());
		try {
			att.transferTo(file);
			return file.getPath();
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//		DataHandler handler = att.getDataHandler();
//		try {
//			InputStream stream = handler.getInputStream();
//			MultivaluedMap map = att.getHeaders();
//			File f = new File(filePath);
//			OutputStream out = new FileOutputStream(f);
//
//			int read = 0;
//			byte[] bytes = new byte[1024];
//			while ((read = stream.read(bytes)) != -1) {
//				out.write(bytes, 0, read);
//			}
//			stream.close();
//			out.flush();
//			out.close();
//			return f.getAbsolutePath();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return null;
	}

	/**
	 * @param att
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static String saveFile(ByteArrayOutputStream att, String filePath) throws IOException {

		File f = new File(filePath);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			att.writeTo(fos);
			fos.close();
			return f.getAbsolutePath();
		} catch (IOException ioe) {
			// Handle exception here
			ioe.printStackTrace();
		} finally {
		}

		return null;

	}
}
