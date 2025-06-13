package com.jacreator.disease_form.views.diphtheria;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;

public class DiphtheriaLabFindingsView extends VerticalLayout {
  private RadioButtonGroup<String> sampleCollected;
  private RadioButtonGroup<String> vaccinated;
  private RadioButtonGroup<String> fbcDifferential;
  private RadioButtonGroup<String> lfts;
  private RadioButtonGroup<String> echo;
  private RadioButtonGroup<String> eUCr;

  public DiphtheriaLabFindingsView() {
    setWidthFull();
    setPadding(true);
    setSpacing(true);

    add(buildForm());
  }

  private FormLayout buildForm() {
    FormLayout form = new FormLayout();
    form.setWidthFull();
    form.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("900px", 3));

    sampleCollected = new RadioButtonGroup<>("Sample collected?");
    sampleCollected.setItems("yes", "no");
    sampleCollected.setRequired(true);
    sampleCollected.setRequiredIndicatorVisible(true);

    vaccinated = new RadioButtonGroup<>("Vaccinated?");
    vaccinated.setItems("yes", "no");
    vaccinated.setRequired(true);
    vaccinated.setRequiredIndicatorVisible(true);

    fbcDifferential = new RadioButtonGroup<>("FBC + Differential?");
    fbcDifferential.setItems("yes", "no");
    fbcDifferential.setRequired(true);
    fbcDifferential.setRequiredIndicatorVisible(true);

    lfts = new RadioButtonGroup<>("LFTs");
    lfts.setItems("yes", "no");
    lfts.setRequired(true);
    lfts.setRequiredIndicatorVisible(true);

    echo = new RadioButtonGroup<>("Echo?");
    echo.setItems("yes", "no");
    echo.setRequired(true);
    echo.setRequiredIndicatorVisible(true);

    eUCr = new RadioButtonGroup<>("E/U/Cr?");
    eUCr.setItems("yes", "no");
    eUCr.setRequired(true);
    eUCr.setRequiredIndicatorVisible(true);

    form.add(
        sampleCollected,
        vaccinated,
        fbcDifferential,
        lfts,
        echo,
        eUCr);

    return form;
  }
}
