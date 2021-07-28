/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jul 28, 2021, 10:32:26 AM                   ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.myproject.core.jalo;

import de.hybris.myproject.core.constants.MyprojectCoreConstants;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.enumeration.EnumerationValue;
import de.hybris.platform.jalo.product.Product;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.myproject.core.jalo.ApparelProduct ApparelProduct}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedApparelProduct extends Product
{
	/** Qualifier of the <code>ApparelProduct.genders</code> attribute **/
	public static final String GENDERS = "genders";
	/** Qualifier of the <code>ApparelProduct.scale</code> attribute **/
	public static final String SCALE = "scale";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(Product.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(GENDERS, AttributeMode.INITIAL);
		tmp.put(SCALE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ApparelProduct.genders</code> attribute.
	 * @return the genders - List of genders that the ApparelProduct is designed for
	 */
	public List<EnumerationValue> getGenders(final SessionContext ctx)
	{
		List<EnumerationValue> coll = (List<EnumerationValue>)getProperty( ctx, GENDERS);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ApparelProduct.genders</code> attribute.
	 * @return the genders - List of genders that the ApparelProduct is designed for
	 */
	public List<EnumerationValue> getGenders()
	{
		return getGenders( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ApparelProduct.genders</code> attribute. 
	 * @param value the genders - List of genders that the ApparelProduct is designed for
	 */
	public void setGenders(final SessionContext ctx, final List<EnumerationValue> value)
	{
		setProperty(ctx, GENDERS,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ApparelProduct.genders</code> attribute. 
	 * @param value the genders - List of genders that the ApparelProduct is designed for
	 */
	public void setGenders(final List<EnumerationValue> value)
	{
		setGenders( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ApparelProduct.scale</code> attribute.
	 * @return the scale - Scale of product
	 */
	public String getScale(final SessionContext ctx)
	{
		return (String)getProperty( ctx, SCALE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ApparelProduct.scale</code> attribute.
	 * @return the scale - Scale of product
	 */
	public String getScale()
	{
		return getScale( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ApparelProduct.scale</code> attribute. 
	 * @param value the scale - Scale of product
	 */
	public void setScale(final SessionContext ctx, final String value)
	{
		setProperty(ctx, SCALE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ApparelProduct.scale</code> attribute. 
	 * @param value the scale - Scale of product
	 */
	public void setScale(final String value)
	{
		setScale( getSession().getSessionContext(), value );
	}
	
}
