package de.hybris.myproject.core.handlers;

import de.hybris.myproject.core.model.ApparelProductModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

import static de.hybris.myproject.core.constants.ScaleConstants.COMMON_SCALE;

public class DisplayingScaleHandler implements DynamicAttributeHandler<String, ApparelProductModel> {
    @Override
    public String get(ApparelProductModel model) {
        return model.getScale() == null ? COMMON_SCALE : model.getScale();
    }

    @Override
    public void set(ApparelProductModel model, String s) {

    }
}
