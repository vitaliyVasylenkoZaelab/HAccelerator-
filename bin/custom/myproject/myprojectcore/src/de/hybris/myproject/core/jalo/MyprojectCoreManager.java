/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.myproject.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.myproject.core.constants.MyprojectCoreConstants;
import de.hybris.myproject.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class MyprojectCoreManager extends GeneratedMyprojectCoreManager
{
	public static final MyprojectCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (MyprojectCoreManager) em.getExtension(MyprojectCoreConstants.EXTENSIONNAME);
	}
}
