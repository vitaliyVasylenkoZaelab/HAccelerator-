package de.hybris.myproject.facades.service;

import de.hybris.myproject.core.model.ApparelProductModel;
import de.hybris.platform.commercefacades.product.data.ProductData;

import java.util.List;

public interface ScaleService {

    List<ApparelProductModel> findAllWithScale();

}
