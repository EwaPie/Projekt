package com.projekt.validator;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class NoBlankValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {
        if (StringUtils.isBlank(value.toString())) {
            FacesMessage msg =
                    new FacesMessage("Niepoprawna wartosc pola Nazwa",
                            "Pole nie moze byc puste");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            PrimeFaces.current().dialog().showMessageDynamic(msg);
            throw new ValidatorException(msg);

        }
    }
}