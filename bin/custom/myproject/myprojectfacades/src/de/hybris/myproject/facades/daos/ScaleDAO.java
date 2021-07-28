package de.hybris.myproject.facades.daos;

import de.hybris.myproject.core.model.ApparelProductModel;

import java.util.List;

public interface ScaleDAO {

    List<ApparelProductModel> findAllWithScale();

}
