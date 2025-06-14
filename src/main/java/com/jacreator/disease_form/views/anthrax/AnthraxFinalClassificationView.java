package com.jacreator.disease_form.views.anthrax;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Arrays;
import java.util.List;

public class AnthraxFinalClassificationView extends VerticalLayout {

  public AnthraxFinalClassificationView() {
    add(createForm());
  }

  private FormLayout createForm() {
    FormLayout formLayout = new FormLayout();

    // Final classification options
    List<String> finals = Arrays.asList(
        "Lab confirmed Anthrax",
        "Epidemiological linked Anthrax",
        "Clinically compatible Anthrax",
        "Discarded",
        "Pending classification");

    // ComboBox for final classification
    ComboBox<String> finalClassification = new ComboBox<>("Select the final classification of this case:");
    finalClassification.setItems(finals);
    finalClassification.setPlaceholder("Select Option");
    finalClassification.setClearButtonVisible(true);

    formLayout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1),
        new FormLayout.ResponsiveStep("600px", 2),
        new FormLayout.ResponsiveStep("700px", 3));
    formLayout.add(finalClassification);

    return formLayout;
  }
}
