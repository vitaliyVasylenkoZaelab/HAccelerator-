package de.hybris.myproject.facades;

import de.hybris.platform.commercefacades.product.data.ProductData;

import java.util.List;

public interface ScaleFacade {

    List<ProductData> findAllWithScale();

}
