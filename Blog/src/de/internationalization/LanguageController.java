package de.internationalization;

import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
//JSF
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//CDI
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;


//@ManagedBean
@Named
@SessionScoped
public class LanguageController implements Serializable {

	private Locale locale;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void changeLocale(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }


}