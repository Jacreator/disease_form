package com.jacreator.disease_form.views.afp;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class AFPView extends VerticalLayout {
  public AFPView() {
    add(
        new EpidemiologicalView(),
        new ClinicalHistoryView(),
        new LaboratoryInformationView(),
        new FinalClassificationView());
  }
}
