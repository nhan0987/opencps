/**
<<<<<<< HEAD
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
=======
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
>>>>>>> FETCH_HEAD
 */

package org.opencps.processmgt.service.impl;

import org.opencps.processmgt.service.base.StepAllowanceLocalServiceBaseImpl;

import org.opencps.processmgt.model.StepAllowance;
import org.opencps.processmgt.service.base.StepAllowanceLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;


/**
 * The implementation of the step allowance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.opencps.processmgt.service.StepAllowanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author khoavd
 * @see org.opencps.processmgt.service.base.StepAllowanceLocalServiceBaseImpl
 * @see org.opencps.processmgt.service.StepAllowanceLocalServiceUtil
 */
public class StepAllowanceLocalServiceImpl
	extends StepAllowanceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.opencps.processmgt.service.StepAllowanceLocalServiceUtil} to access the step allowance local service.
	 */
	
	/**
	 * Add StepAllowance
	 * 
	 * @param processStepId
	 * @param roleId
	 * @param readOnly
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public StepAllowance addAllowance(
	    long processStepId, long roleId, boolean readOnly)
	    throws PortalException, SystemException {
		
		StepAllowance stepAllowance = stepAllowancePersistence.fetchBySTEP_ROLE(processStepId, readOnly);
		
		long stepAllowanceId = counterLocalService.increment(StepAllowance.class.getName());
		
		stepAllowance = stepAllowancePersistence.create(stepAllowanceId);
		
		if (Validator.isNotNull(stepAllowance)) {
			
			stepAllowance.setProcessStepId(processStepId);
			stepAllowance.setRoleId(roleId);
			stepAllowance.setReadOnly(readOnly);
			
			stepAllowancePersistence.update(stepAllowance);
		}
		
		return stepAllowance;
		
	}
	
}