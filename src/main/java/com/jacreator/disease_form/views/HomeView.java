package com.jacreator.disease_form.views;

import com.vaadin.flow.theme.lumo.LumoUtility;

import com.jacreator.disease_form.views.afp.AFPView;
import com.jacreator.disease_form.views.afp.ClinicalHistoryView;
import com.jacreator.disease_form.views.afp.EpidemiologicalView;
import com.jacreator.disease_form.views.afp.FinalClassificationView;
import com.jacreator.disease_form.views.afp.LaboratoryInformationView;
import com.jacreator.disease_form.views.anthrax.AnthraxClinicalHistoryView;
import com.jacreator.disease_form.views.anthrax.AnthraxContactTracingView;
import com.jacreator.disease_form.views.anthrax.AnthraxEpidemiologicalView;
import com.jacreator.disease_form.views.anthrax.AnthraxFinalClassificationView;
import com.jacreator.disease_form.views.anthrax.AnthraxLaboratoryInformationView;
import com.jacreator.disease_form.views.buruliUlcer.BuruliUlcerClinicalHistoryView;
import com.jacreator.disease_form.views.buruliUlcer.BuruliUlcerContactTracingView;
import com.jacreator.disease_form.views.buruliUlcer.BuruliUlcerEpidemiologicalView;
import com.jacreator.disease_form.views.buruliUlcer.BuruliUlcerFinalClassificationView;
import com.jacreator.disease_form.views.buruliUlcer.BuruliUlcerLaboratoryInformationView;
import com.jacreator.disease_form.views.buruliUlcer.BuruliUlcerReferralView;
import com.jacreator.disease_form.views.cholera.CholeraClinicalHistoryView;
import com.jacreator.disease_form.views.cholera.CholeraContactTracingView;
import com.jacreator.disease_form.views.cholera.CholeraEpidemiologicalView;
import com.jacreator.disease_form.views.cholera.CholeraFinalClassificationView;
import com.jacreator.disease_form.views.cholera.CholeraLaboratoryInformationView;
import com.jacreator.disease_form.views.covid19.Covid19ClinicalHistoryView;
import com.jacreator.disease_form.views.covid19.Covid19ContactTracingView;
import com.jacreator.disease_form.views.covid19.Covid19EpidemiologicalView;
import com.jacreator.disease_form.views.covid19.Covid19FinalClassificationView;
import com.jacreator.disease_form.views.covid19.Covid19LaboratoryInformationView;
import com.jacreator.disease_form.views.csm.CSMClinicalHistoryView;
import com.jacreator.disease_form.views.csm.CSMContactTracingView;
import com.jacreator.disease_form.views.csm.CSMEpidemiologicalView;
import com.jacreator.disease_form.views.csm.CSMFinalClassificationView;
import com.jacreator.disease_form.views.csm.CSMLaboratoryInformationView;
import com.jacreator.disease_form.views.dengue.DengueClinicalHistoryView;
import com.jacreator.disease_form.views.dengue.DengueContactTracingView;
import com.jacreator.disease_form.views.dengue.DengueEpidemiologicalView;
import com.jacreator.disease_form.views.dengue.DengueFinalClassificationView;
import com.jacreator.disease_form.views.dengue.DengueLaboratoryInformationView;
import com.jacreator.disease_form.views.diphtheria.ComplicationsView;
import com.jacreator.disease_form.views.diphtheria.DiphtheriaClinicalHistoryView;
import com.jacreator.disease_form.views.diphtheria.DiphtheriaContactTracingView;
import com.jacreator.disease_form.views.diphtheria.DiphtheriaCpostComplicationsView;
import com.jacreator.disease_form.views.diphtheria.DiphtheriaEpidemiologicalView;
import com.jacreator.disease_form.views.diphtheria.DiphtheriaFinalClassificationView;
import com.jacreator.disease_form.views.diphtheria.DiphtheriaLabFindingsView;
import com.jacreator.disease_form.views.diphtheria.DiphtheriaLaboratoryInformationView;
import com.jacreator.disease_form.views.diphtheria.DiphtheriaManagementView;
import com.jacreator.disease_form.views.diphtheria.DiphtheriaSignAndSymptoms;
import com.jacreator.disease_form.views.diphtheria.DiphtheriaVitalSignsOnAdmission;
import com.jacreator.disease_form.views.ebola.EbolaClinicalHistoryView;
import com.jacreator.disease_form.views.ebola.EbolaContactTracingView;
import com.jacreator.disease_form.views.ebola.EbolaEpidemiologicalView;
import com.jacreator.disease_form.views.ebola.EbolaFinalClassificationView;
import com.jacreator.disease_form.views.ebola.EbolaLaboratoryInformationView;
import com.jacreator.disease_form.views.guinea_worm.GuineaWormClinicalHistoryView;
import com.jacreator.disease_form.views.guinea_worm.GuineaWormContactTracingView;
import com.jacreator.disease_form.views.guinea_worm.GuineaWormEpidemiologicalView;
import com.jacreator.disease_form.views.guinea_worm.GuineaWormFinalClassificationView;
import com.jacreator.disease_form.views.guinea_worm.GuineaWormLaboratoryInformationView;
import com.jacreator.disease_form.views.influenza.InfluenzaClinicalHistoryView;
import com.jacreator.disease_form.views.influenza.InfluenzaContactTracingView;
import com.jacreator.disease_form.views.influenza.InfluenzaEpidemiologicalView;
import com.jacreator.disease_form.views.influenza.InfluenzaFinalClassificationView;
import com.jacreator.disease_form.views.influenza.InfluenzaLaboratoryInformationView;
import com.jacreator.disease_form.views.lassa_fever.LassaFeverClinicalHistoryView;
import com.jacreator.disease_form.views.lassa_fever.LassaFeverContactTracingView;
import com.jacreator.disease_form.views.lassa_fever.LassaFeverEpidemiologicalView;
import com.jacreator.disease_form.views.lassa_fever.LassaFeverFinalClassificationView;
import com.jacreator.disease_form.views.lassa_fever.LassaFeverLaboratoryInformationView;
import com.jacreator.disease_form.views.maternal_death.MaternalDeathClinicalHistoryView;
import com.jacreator.disease_form.views.maternal_death.MaternalDeathContactTracingView;
import com.jacreator.disease_form.views.maternal_death.MaternalDeathEpidemiologicalView;
import com.jacreator.disease_form.views.maternal_death.MaternalDeathFinalClassificationView;
import com.jacreator.disease_form.views.maternal_death.MaternalDeathLaboratoryInformationView;
import com.jacreator.disease_form.views.measles.MeaslesClinicalHistoryView;
import com.jacreator.disease_form.views.measles.MeaslesContactTracingView;
import com.jacreator.disease_form.views.measles.MeaslesEpidemiologicalView;
import com.jacreator.disease_form.views.measles.MeaslesFinalClassificationView;
import com.jacreator.disease_form.views.measles.MeaslesLaboratoryInformationView;
import com.jacreator.disease_form.views.mpox.MpoxClinicalHistoryView;
import com.jacreator.disease_form.views.mpox.MpoxContactTracingView;
import com.jacreator.disease_form.views.mpox.MpoxEpidemiologicalView;
import com.jacreator.disease_form.views.mpox.MpoxFinalClassificationView;
import com.jacreator.disease_form.views.mpox.MpoxLaboratoryInformationView;
import com.jacreator.disease_form.views.noma.NOMAClinicalHistoryView;
import com.jacreator.disease_form.views.noma.NOMAContactTracingView;
import com.jacreator.disease_form.views.noma.NOMAEpidemiologicalView;
import com.jacreator.disease_form.views.noma.NOMAFinalClassificationView;
import com.jacreator.disease_form.views.noma.NOMALaboratoryInformationView;
import com.jacreator.disease_form.views.perinatal_death.PerinatalDeathClinicalHistoryView;
import com.jacreator.disease_form.views.perinatal_death.PerinatalDeathContactTracingView;
import com.jacreator.disease_form.views.perinatal_death.PerinatalDeathEpidemiologicalView;
import com.jacreator.disease_form.views.perinatal_death.PerinatalDeathFinalClassificationView;
import com.jacreator.disease_form.views.perinatal_death.PerinatalDeathLaboratoryInformationView;
import com.jacreator.disease_form.views.pfds.PRDSClinicalHistoryView;
import com.jacreator.disease_form.views.pfds.PRDSEpidemiologicalView;
import com.jacreator.disease_form.views.pfds.PRDSFinalClassificationView;
import com.jacreator.disease_form.views.pfds.PRDSLaboratoryInformationView;
import com.jacreator.disease_form.views.rubella.RubellaClinicalHistoryView;
import com.jacreator.disease_form.views.rubella.RubellaContactTracingView;
import com.jacreator.disease_form.views.rubella.RubellaEpidemiologicalView;
import com.jacreator.disease_form.views.rubella.RubellaFinalClassificationView;
import com.jacreator.disease_form.views.rubella.RubellaLaboratoryInformationView;
import com.jacreator.disease_form.views.tetanus.TetanusClinicalHistoryView;
import com.jacreator.disease_form.views.tetanus.TetanusContactTracingView;
import com.jacreator.disease_form.views.tetanus.TetanusEpidemiologicalView;
import com.jacreator.disease_form.views.tetanus.TetanusFinalClassificationView;
import com.jacreator.disease_form.views.tetanus.TetanusLaboratoryInformationView;
import com.jacreator.disease_form.views.yellow_fever.YellowFeverClinicalHistoryView;
import com.jacreator.disease_form.views.yellow_fever.YellowFeverContactTracingView;
import com.jacreator.disease_form.views.yellow_fever.YellowFeverEpidemiologicalView;
import com.jacreator.disease_form.views.yellow_fever.YellowFeverFinalClassificationView;
import com.jacreator.disease_form.views.yellow_fever.YellowFeverLaboratoryInformationView;
import com.jacreator.disease_form.views.yew.YewClinicalHistoryView;
import com.jacreator.disease_form.views.yew.YewContactTracingView;
import com.jacreator.disease_form.views.yew.YewEpidemiologicalView;
import com.jacreator.disease_form.views.yew.YewFinalClassificationView;
import com.jacreator.disease_form.views.yew.YewLaboratoryInformationView;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.HashMap;
import java.util.Map;

@Route("")
public class HomeView extends VerticalLayout {

  private final ComboBox<String> diseaseCombo;
  private final Map<String, VerticalLayout> diseaseComponents = new HashMap<>();
  private final Accordion accordion;

  public HomeView() {
    setWidthFull();
    // Disease selection
    diseaseCombo = new ComboBox<>("Disease name");
    diseaseCombo.setItems(
        "Cholera", "Yellow Fever", "Yaw", "Anthrax", "AFP", "PRDS", "Tetanus", "Rubella",
        "Perinatal Death", "NOMA", "Mpox", "Measles", "Maternal Death", "Lassa Fever",
        "Influenza", "Guinea Worm", "Ebola", "Diphtheria", "Dengue", "CSM", "Covid19", "Buruli Ulcer");
    diseaseCombo.setClearButtonVisible(true);

    // Accordion for Patient Info
    accordion = new Accordion();

    // Add components to the layout
    add(diseaseCombo, accordion);

    // Show disease-specific section on selection
    diseaseCombo.addValueChangeListener(e -> {
      // Remove all panels and re-add patient info
      accordion.close();
      accordion.getChildren().forEach(component -> accordion.remove((AccordionPanel) component));
      accordion.add("Reporting Areas", new ReportingAreasView());
      accordion.add("Patient Information", new PatientView());

      String selectedDisease = e.getValue();
      if (selectedDisease == null) {
        return;
      }

      switch (selectedDisease) {
        case "AFP":
          accordion.add("Epidemiological Information", new EpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new ClinicalHistoryView());
          accordion.add("Laboratory information", new LaboratoryInformationView());
          accordion.add("Final Classification", new FinalClassificationView());
          break;
        case "Anthrax":
          accordion.add("Epidemiological Information", new AnthraxEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new AnthraxClinicalHistoryView());
          accordion.add("Laboratory information", new AnthraxLaboratoryInformationView());
          accordion.add("Final Classification", new AnthraxFinalClassificationView());
          accordion.add("Contact Tracing", new AnthraxContactTracingView());
          break;
        case "Buruli Ulcer":
          accordion.add("Epidemiological Information", new BuruliUlcerEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new BuruliUlcerClinicalHistoryView());
          accordion.add("Laboratory information", new BuruliUlcerLaboratoryInformationView());
          accordion.add("Final Classification", new BuruliUlcerFinalClassificationView());
          accordion.add("Contact Tracing", new BuruliUlcerContactTracingView());
          accordion.add("Referral", new BuruliUlcerReferralView());
          break;
        case "Cholera":
          accordion.add("Epidemiological Information", new CholeraEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new CholeraClinicalHistoryView());
          accordion.add("Contact Tracing", new CholeraContactTracingView());
          accordion.add("Laboratory information", new CholeraLaboratoryInformationView());
          accordion.add("Final Classification", new CholeraFinalClassificationView());
          break;
        case "Yellow Fever":
          accordion.add("Epidemiological Information", new YellowFeverEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new YellowFeverClinicalHistoryView());
          accordion.add("Contact Tracing", new YellowFeverContactTracingView());
          accordion.add("Laboratory information", new YellowFeverLaboratoryInformationView());
          accordion.add("Final Classification", new YellowFeverFinalClassificationView());
          break;
        case "Yaw":
          accordion.add("Epidemiological Information", new YewEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new YewClinicalHistoryView());
          accordion.add("Contact Tracing", new YewContactTracingView());
          accordion.add("Laboratory information", new YewLaboratoryInformationView());
          accordion.add("Final Classification", new YewFinalClassificationView());
          break;
        case "PRDS":
          accordion.add("Epidemiological Information", new PRDSEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new PRDSClinicalHistoryView());
          accordion.add("Laboratory information", new PRDSLaboratoryInformationView());
          accordion.add("Final Classification", new PRDSFinalClassificationView());
          break;
        case "Tetanus":
          accordion.add("Epidemiological Information", new TetanusEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new TetanusClinicalHistoryView());
          accordion.add("Contact Tracing", new TetanusContactTracingView());
          accordion.add("Laboratory information", new TetanusLaboratoryInformationView());
          accordion.add("Final Classification", new TetanusFinalClassificationView());
          break;
        case "Rubella":
          accordion.add("Epidemiological Information", new RubellaEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new RubellaClinicalHistoryView());
          accordion.add("Contact Tracing", new RubellaContactTracingView());
          accordion.add("Laboratory information", new RubellaLaboratoryInformationView());
          accordion.add("Final Classification", new RubellaFinalClassificationView());
          break;
        case "Perinatal Death":
          accordion.add("Epidemiological Information", new PerinatalDeathEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new PerinatalDeathClinicalHistoryView());
          accordion.add("Contact Tracing", new PerinatalDeathContactTracingView());
          accordion.add("Laboratory information", new PerinatalDeathLaboratoryInformationView());
          accordion.add("Final Classification", new PerinatalDeathFinalClassificationView());
          break;
        case "NOMA":
          accordion.add("Epidemiological Information", new NOMAEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new NOMAClinicalHistoryView());
          accordion.add("Contact Tracing", new NOMAContactTracingView());
          accordion.add("Laboratory information", new NOMALaboratoryInformationView());
          accordion.add("Final Classification", new NOMAFinalClassificationView());
          break;
        case "Mpox":
          accordion.add("Epidemiological Information", new MpoxEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new MpoxClinicalHistoryView());
          accordion.add("Contact Tracing", new MpoxContactTracingView());
          accordion.add("Laboratory information", new MpoxLaboratoryInformationView());
          accordion.add("Final Classification", new MpoxFinalClassificationView());
          break;
        case "Measles":
          accordion.add("Epidemiological Information", new MeaslesEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new MeaslesClinicalHistoryView());
          accordion.add("Contact Tracing", new MeaslesContactTracingView());
          accordion.add("Laboratory information", new MeaslesLaboratoryInformationView());
          accordion.add("Final Classification", new MeaslesFinalClassificationView());
          break;
        case "Lassa Fever":
          accordion.add("Epidemiological Information", new LassaFeverEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new LassaFeverClinicalHistoryView());
          accordion.add("Contact Tracing", new LassaFeverContactTracingView());
          accordion.add("Laboratory information", new LassaFeverLaboratoryInformationView());
          accordion.add("Final Classification", new LassaFeverFinalClassificationView());
          break;
        case "Influenza":
          accordion.add("Epidemiological Information", new InfluenzaEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new InfluenzaClinicalHistoryView());
          accordion.add("Contact Tracing", new InfluenzaContactTracingView());
          accordion.add("Laboratory information", new InfluenzaLaboratoryInformationView());
          accordion.add("Final Classification", new InfluenzaFinalClassificationView());
          break;
        case "Guinea Worm":
          accordion.add("Epidemiological Information", new GuineaWormEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new GuineaWormClinicalHistoryView());
          accordion.add("Contact Tracing", new GuineaWormContactTracingView());
          accordion.add("Laboratory information", new GuineaWormLaboratoryInformationView());
          accordion.add("Final Classification", new GuineaWormFinalClassificationView());
          break;
        case "Ebola":
          accordion.add("Epidemiological Information", new EbolaEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new EbolaClinicalHistoryView());
          accordion.add("Contact Tracing", new EbolaContactTracingView());
          accordion.add("Laboratory information", new EbolaLaboratoryInformationView());
          accordion.add("Final Classification", new EbolaFinalClassificationView());
          break;
        case "Diphtheria":
          accordion.add("Vital Signs on Admission", new DiphtheriaVitalSignsOnAdmission());
          accordion.add("Sign and Symptoms", new DiphtheriaSignAndSymptoms());
          accordion.add("Complications", new ComplicationsView());
          accordion.add("Management", new DiphtheriaManagementView());
          accordion.add("Lab Findings", new DiphtheriaLabFindingsView());
          accordion.add("Follow up for cpost Diphtheric complications", new DiphtheriaCpostComplicationsView());
          break;
        case "Dengue":
          accordion.add("Epidemiological Information", new DengueEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new DengueClinicalHistoryView());
          accordion.add("Contact Tracing", new DengueContactTracingView());
          accordion.add("Laboratory information", new DengueLaboratoryInformationView());
          accordion.add("Final Classification", new DengueFinalClassificationView());
          break;
        case "Maternal Death":
          accordion.add("Epidemiological Information", new MaternalDeathEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new MaternalDeathClinicalHistoryView());
          accordion.add("Contact Tracing", new MaternalDeathContactTracingView());
          accordion.add("Laboratory information", new MaternalDeathLaboratoryInformationView());
          accordion.add("Final Classification", new MaternalDeathFinalClassificationView());
          break;
        case "CSM":
          accordion.add("Epidemiological Information", new CSMEpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new CSMClinicalHistoryView());
          accordion.add("Contact Tracing", new CSMContactTracingView());
          accordion.add("Laboratory information", new CSMLaboratoryInformationView());
          accordion.add("Final Classification", new CSMFinalClassificationView());
          break;
        case "Covid19":
          accordion.add("Epidemiological Information", new Covid19EpidemiologicalView());
          accordion.add("Clinical history: Sign and Symptoms", new Covid19ClinicalHistoryView());
          accordion.add("Contact Tracing", new Covid19ContactTracingView());
          accordion.add("Laboratory information", new Covid19LaboratoryInformationView());
          accordion.add("Final Classification", new Covid19FinalClassificationView());
          break;
        default:
          if (diseaseComponents.containsKey(selectedDisease)) {
            accordion.add(selectedDisease + " Section", diseaseComponents.get(selectedDisease));
          }
          break;
      }
    });

    // Submit button
    Button submit = new Button("Submit Case", event -> {
      Notification.show("Form submitted!");
      // Here, collect and process form data as needed
    });

    diseaseCombo.getStyle().set("width", "100%");
    diseaseCombo.getStyle().set("max-width", "800px");
    diseaseCombo.getStyle().set("margin-left", "auto");
    diseaseCombo.getStyle().set("margin-right", "auto");
    diseaseCombo.getStyle().set("padding-left", "40px");
    diseaseCombo.getStyle().set("padding-right", "40px");

    accordion.getStyle().set("width", "100%");
    accordion.getStyle().set("max-width", "800px");
    accordion.getStyle().set("margin-right", "auto");
    accordion.getStyle().set("margin-left", "auto");
    accordion.getStyle().set("padding-left", "40px");
    accordion.getStyle().set("padding-right", "40px");

    submit.getStyle().set("margin-left", "auto");
    submit.getStyle().set("margin-right", "auto");

    // Add the form and submit button to the layout
    add(diseaseCombo, accordion, submit);
  }
}
