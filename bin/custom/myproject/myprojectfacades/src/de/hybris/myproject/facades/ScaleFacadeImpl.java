package de.hybris.myproject.facades;

import de.hybris.myproject.core.model.ApparelProductModel;
import de.hybris.myproject.facades.service.ScaleService;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class ScaleFacadeImpl implements ScaleFacade {

    private ScaleService scaleService;
    private Converter<ApparelProductModel, ProductData> scaleConverter;

    @Override
    public List<ProductData> findAllWithScale() {
        List<ApparelProductModel> product = scaleService.findAllWithScale();
        return product.stream()
                .map(it -> scaleConverter.convert(it, new ProductData()))
                .collect(Collectors.toList());
    }

    public void setScaleService(final ScaleService scaleService) {
        this.scaleService = scaleService;
    }

    public void setScaleConverter(Converter<ApparelProductModel, ProductData> scaleConverter) {
        this.scaleConverter = scaleConverter;
    }
}
