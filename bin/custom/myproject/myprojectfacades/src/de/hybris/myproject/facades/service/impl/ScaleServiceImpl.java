package de.hybris.myproject.facades.service.impl;

import de.hybris.myproject.core.model.ApparelProductModel;
import de.hybris.myproject.facades.daos.ScaleDAO;
import de.hybris.myproject.facades.service.ScaleService;

import java.util.List;

public class ScaleServiceImpl implements ScaleService {

    private ScaleDAO scaleDAO;

    @Override
    public List<ApparelProductModel> findAllWithScale() {
        return scaleDAO.findAllWithScale();
    }

    public void setScaleDAO(final ScaleDAO scaleDAO) {
        this.scaleDAO = scaleDAO;
    }

}
