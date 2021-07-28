/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.myproject.facades.populators;

import de.hybris.myproject.core.model.ApparelProductModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commerceservices.url.UrlResolver;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.variants.model.VariantProductModel;

public class ScaleProductPopulator implements Populator<ProductModel, ProductData>
{
	private UrlResolver<ProductModel> productModelUrlResolver;

	@Override
	public void populate(final ProductModel source, final ProductData target) throws ConversionException
	{
		final ProductModel baseProduct = getBaseProduct(source);

		if (baseProduct instanceof ApparelProductModel)
		{
			final ApparelProductModel apparelProductModel = (ApparelProductModel) baseProduct;
			target.setUrl(getProductModelUrlResolver().resolve(source));
			target.setScale(apparelProductModel.getScale());
			target.setDisplayingScale(apparelProductModel.getDisplayingScale());
			target.setName(apparelProductModel.getName());
			target.setCode(apparelProductModel.getCode());
		}
	}

	protected ProductModel getBaseProduct(final ProductModel productModel)
	{
		ProductModel currentProduct = productModel;
		while (currentProduct instanceof VariantProductModel)
		{
			final VariantProductModel variant = (VariantProductModel) currentProduct;
			currentProduct = variant.getBaseProduct();
		}
		return currentProduct;
	}

	protected UrlResolver<ProductModel> getProductModelUrlResolver()
	{
		return productModelUrlResolver;
	}

	public void setProductModelUrlResolver(final UrlResolver<ProductModel> productModelUrlResolver)
	{
		this.productModelUrlResolver = productModelUrlResolver;
	}
}
