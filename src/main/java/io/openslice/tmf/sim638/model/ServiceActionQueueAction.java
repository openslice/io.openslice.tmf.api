/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.sim638.model;

public enum ServiceActionQueueAction {

	NONE,
	CREATE,
	MODIFY,
	DEACTIVATE,
	TERMINATE,
	EVALUATE_STATE_CHANGE_TOACTIVE,
	EVALUATE_STATE_CHANGE_TOINACTIVE,
	EVALUATE_CHARACTERISTIC_CHANGED,
	EVALUATE_CHARACTERISTIC_CHANGED_MANODAY2
}
