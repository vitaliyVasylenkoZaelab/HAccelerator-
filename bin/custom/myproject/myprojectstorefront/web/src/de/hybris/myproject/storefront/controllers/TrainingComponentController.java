package de.hybris.myproject.storefront.controllers;
import javax.servlet.http.HttpServletRequest;

import de.hybris.myproject.storefront.controllers.cms.AbstractAcceleratorCMSComponentController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.hybrisinstructive.core.model.TrainingComponentModel;


@Controller("TrainingComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.TrainingComponent)
public class TrainingComponentController extends AbstractAcceleratorCMSComponentController<TrainingComponentModel>

{
    @Override
    protected void fillModel(final HttpServletRequest request, final Model model, final TrainingComponentModel component)
    {
        model.addAttribute("productName", component.getProductName());

        model.addAttribute("brand", component.getBrand());

        model.addAttribute("productImage", component.getProductImage());

    }


}
