package de.hybris.myproject.storefront.controllers;

import de.hybris.myproject.facades.ScaleFacadeImpl;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.commercefacades.product.data.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller("Controller")
public class ProductScaleController extends AbstractPageController {

    public static final String BAND_LIST = "pages/bandList";
    private ScaleFacadeImpl scaleFacade;

    @RequestMapping(value = "/scale/products")
    public String showBands(final Model model)
    {
        final List<ProductData> products = scaleFacade.findAllWithScale();
        model.addAttribute("products", products);
        return BAND_LIST;
    }

    @Autowired
    public void setFacade(final ScaleFacadeImpl scaleFacade)
    {
        this.scaleFacade = scaleFacade;
    }
}
