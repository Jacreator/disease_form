package com.jacreator.disease_form.views.lassa_fever;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;

public class LassaFeverEpidemiologicalView extends VerticalLayout {
// State for dynamic fields
    private final Map<String, List<String>> lgaData = new HashMap<>();
    private ComboBox<String> lgaOfTravel;

    // Dynamic field references
    private DatePicker startDateTraveled, endDateTraveled;
    private ComboBox<String> stateOfTravel;
    private TextField clientTravelAddress;
    private ComboBox<String> lgaOfTravelCombo;

    private RadioButtonGroup<String> huntAnyRodent, eatAnyRodent, noticedRodentOrRodentUrineOrFaeces, dryFoodstuffsInTheOpen;
    private TextField nameOrAddressOfCase;
    private DatePicker dateHospitalVisitOrAdmission;
    private TextField nameorAddressOfHealthFacilityVisitedOrAdmitted;
    private DatePicker dateOutpatientVisit;
    private TextField nameOrAddressOfOutpatientHealthFacilityVisited;
    private DatePicker dateLabPositiveResult;
    private RadioButtonGroup<String> wherePatientDied, modeOfBurial;

    public LassaFeverEpidemiologicalView() {
        setWidthFull();

        // State and LGA data
        lgaData.put("FCT", Arrays.asList("AMAC", "Bwari", "Kwali"));
        lgaData.put("Enugu", Arrays.asList("Nsukka", "Enugu south", "Udi"));
        add(buildForm());
    }

    private FormLayout buildForm() {
        FormLayout form = new FormLayout();

        // --- Main fields ---
        // Have you travelled within the last 3 weeks before becoming ill?
        RadioButtonGroup<String> travelledWithinLastThreeweeks = new RadioButtonGroup<>();
        travelledWithinLastThreeweeks.setLabel("Have you travelled within the last 3 weeks before becoming ill?");
        travelledWithinLastThreeweeks.setItems("Yes", "No", "Unknown");
        travelledWithinLastThreeweeks.setRequired(true);

        // Travel details (conditional)
        startDateTraveled = new DatePicker("Travel start date");
        startDateTraveled.setMax(LocalDate.now());
        startDateTraveled.setRequired(true);
        startDateTraveled.setVisible(false);

        endDateTraveled = new DatePicker("Travel end date");
        endDateTraveled.setMax(LocalDate.now());
        endDateTraveled.setRequired(true);
        endDateTraveled.setVisible(false);

        stateOfTravel = new ComboBox<>("State");
        stateOfTravel.setItems("FCT", "Enugu");
        stateOfTravel.setPlaceholder("Select State");
        stateOfTravel.setRequired(true);
        stateOfTravel.setVisible(false);

        lgaOfTravelCombo = new ComboBox<>("LGA");
        lgaOfTravelCombo.setPlaceholder("Select LGA");
        lgaOfTravelCombo.setRequired(true);
        lgaOfTravelCombo.setVisible(false);

        clientTravelAddress = new TextField("Travel address");
        clientTravelAddress.setPlaceholder("Enter address visited");
        clientTravelAddress.setVisible(false);

        // Dynamic LGA population
        stateOfTravel.addValueChangeListener(event -> {
            String state = event.getValue();
            List<String> lgas = lgaData.getOrDefault(state, Collections.emptyList());
            lgaOfTravelCombo.setItems(lgas);
        });

        // Contact with rodent(rat)?
        RadioButtonGroup<String> contactRodent = new RadioButtonGroup<>();
        contactRodent.setLabel("Contact with rodent(rat)?");
        contactRodent.setItems("Yes", "No", "Unknown");
        contactRodent.setRequired(true);

        // Rodent details (conditional)
        huntAnyRodent = new RadioButtonGroup<>();
        huntAnyRodent.setLabel("Did you hunt any rodent(rat) in the last three weeks before becoming ill?");
        huntAnyRodent.setItems("Yes", "No");
        huntAnyRodent.setRequired(true);
        huntAnyRodent.setVisible(false);

        eatAnyRodent = new RadioButtonGroup<>();
        eatAnyRodent.setLabel("Did you eat any rodent (rat) in the last three weeks before becoming ill?");
        eatAnyRodent.setItems("Yes", "No");
        eatAnyRodent.setRequired(true);
        eatAnyRodent.setVisible(false);

        noticedRodentOrRodentUrineOrFaeces = new RadioButtonGroup<>();
        noticedRodentOrRodentUrineOrFaeces.setLabel("Have you noticed any rodent(rat) or rodent's urine/faeces around the house?");
        noticedRodentOrRodentUrineOrFaeces.setItems("Yes", "No");
        noticedRodentOrRodentUrineOrFaeces.setRequired(true);
        noticedRodentOrRodentUrineOrFaeces.setVisible(false);

        dryFoodstuffsInTheOpen = new RadioButtonGroup<>();
        dryFoodstuffsInTheOpen.setLabel("Do you or your family dry foodstuffs in the open?");
        dryFoodstuffsInTheOpen.setItems("Yes", "No");
        dryFoodstuffsInTheOpen.setRequired(true);
        dryFoodstuffsInTheOpen.setVisible(false);

        // Contact with suspected or confirmed case?
        RadioButtonGroup<String> contactWithSuspectedConfirmedCase = new RadioButtonGroup<>();
        contactWithSuspectedConfirmedCase.setLabel("Contact with suspected or confirmed case?");
        contactWithSuspectedConfirmedCase.setItems("Yes", "No", "Unknown");
        contactWithSuspectedConfirmedCase.setRequired(true);

        // Details of the case (conditional)
        nameOrAddressOfCase = new TextField("Details of the case");
        nameOrAddressOfCase.setPlaceholder("Enter name or address of case");
        nameOrAddressOfCase.setVisible(false);

        // Have you visited or been admitted to any inpatient health facility?
        RadioButtonGroup<String> visitedOrAdmittedInpatient = new RadioButtonGroup<>();
        visitedOrAdmittedInpatient.setLabel("Have you visited or been admitted to any inpatient health facility?");
        visitedOrAdmittedInpatient.setItems("Yes", "No", "Unknown");
        visitedOrAdmittedInpatient.setRequired(true);

        // Inpatient details (conditional)
        dateHospitalVisitOrAdmission = new DatePicker("Date of visit or admission");
        dateHospitalVisitOrAdmission.setMax(LocalDate.now());
        dateHospitalVisitOrAdmission.setRequired(true);
        dateHospitalVisitOrAdmission.setVisible(false);

        nameorAddressOfHealthFacilityVisitedOrAdmitted = new TextField("Name/address of health facility visited or admitted in");
        nameorAddressOfHealthFacilityVisitedOrAdmitted.setPlaceholder("Enter name/Address");
        nameorAddressOfHealthFacilityVisitedOrAdmitted.setVisible(false);

        // Have you visited any outpatient health facility?
        RadioButtonGroup<String> visitOutpatient = new RadioButtonGroup<>();
        visitOutpatient.setLabel("Have you visited any outpatient health facility?");
        visitOutpatient.setItems("Yes", "No", "Unknown");
        visitOutpatient.setRequired(true);

        // Outpatient details (conditional)
        dateOutpatientVisit = new DatePicker("Date of visit");
        dateOutpatientVisit.setMax(LocalDate.now());
        dateOutpatientVisit.setRequired(true);
        dateOutpatientVisit.setVisible(false);

        nameOrAddressOfOutpatientHealthFacilityVisited = new TextField("Name/address of outpatient health facility visited");
        nameOrAddressOfOutpatientHealthFacilityVisited.setPlaceholder("Enter Name/Address");
        nameOrAddressOfOutpatientHealthFacilityVisited.setVisible(false);

        // In the last 3 weeks did you participate in any form of burial rite?
        RadioButtonGroup<String> participateInBurialrite = new RadioButtonGroup<>();
        participateInBurialrite.setLabel("In the last 3 weeks did you participate in any form of burial rite?");
        participateInBurialrite.setItems("Yes", "No", "Unknown");
        participateInBurialrite.setRequired(true);

        // Have you ever had a laboratory positive result?
        RadioButtonGroup<String> hadLabPositiveResult = new RadioButtonGroup<>();
        hadLabPositiveResult.setLabel("Have you ever had a laboratory positive result?");
        hadLabPositiveResult.setItems("Yes", "No", "Unknown");
        hadLabPositiveResult.setRequired(true);

        // Date of laboratory positive result (conditional)
        dateLabPositiveResult = new DatePicker("Date of laboratory positive result");
        dateLabPositiveResult.setMax(LocalDate.now());
        dateLabPositiveResult.setVisible(false);

        // Present condition
        RadioButtonGroup<String> presentCondition = new RadioButtonGroup<>();
        presentCondition.setLabel("Present condition");
        presentCondition.setItems("Alive", "Dead");
        presentCondition.setRequired(true);

        // If dead: where and mode of burial
        wherePatientDied = new RadioButtonGroup<>();
        wherePatientDied.setLabel("Where did the patient die?");
        wherePatientDied.setItems("Died at home", "Died at health facility");
        wherePatientDied.setRequired(true);
        wherePatientDied.setVisible(false);

        modeOfBurial = new RadioButtonGroup<>();
        modeOfBurial.setLabel("Mode of burial");
        modeOfBurial.setItems("Safe", "Unsafe");
        modeOfBurial.setRequired(true);
        modeOfBurial.setVisible(false);

        // --- Conditional logic ---
        travelledWithinLastThreeweeks.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            startDateTraveled.setVisible(show);
            endDateTraveled.setVisible(show);
            stateOfTravel.setVisible(show);
            lgaOfTravelCombo.setVisible(show);
            clientTravelAddress.setVisible(show);
        });

        contactRodent.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            huntAnyRodent.setVisible(show);
            eatAnyRodent.setVisible(show);
            noticedRodentOrRodentUrineOrFaeces.setVisible(show);
            dryFoodstuffsInTheOpen.setVisible(show);
        });

        contactWithSuspectedConfirmedCase.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            nameOrAddressOfCase.setVisible(show);
        });

        visitedOrAdmittedInpatient.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateHospitalVisitOrAdmission.setVisible(show);
            nameorAddressOfHealthFacilityVisitedOrAdmitted.setVisible(show);
        });

        visitOutpatient.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateOutpatientVisit.setVisible(show);
            nameOrAddressOfOutpatientHealthFacilityVisited.setVisible(show);
        });

        hadLabPositiveResult.addValueChangeListener(event -> {
            boolean show = "Yes".equals(event.getValue());
            dateLabPositiveResult.setVisible(show);
        });

        presentCondition.addValueChangeListener(event -> {
            boolean show = "Dead".equals(event.getValue());
            wherePatientDied.setVisible(show);
            modeOfBurial.setVisible(show);
        });

        // Responsive steps
        form.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px", 2),
            new FormLayout.ResponsiveStep("700px", 3));

        // Add all fields to the form
        form.add(
            travelledWithinLastThreeweeks,
            startDateTraveled,
            endDateTraveled,
            stateOfTravel,
            lgaOfTravelCombo,
            clientTravelAddress,

            contactRodent,
            huntAnyRodent,
            eatAnyRodent,
            noticedRodentOrRodentUrineOrFaeces,
            dryFoodstuffsInTheOpen,

            contactWithSuspectedConfirmedCase,
            nameOrAddressOfCase,

            visitedOrAdmittedInpatient,
            dateHospitalVisitOrAdmission,
            nameorAddressOfHealthFacilityVisitedOrAdmitted,

            visitOutpatient,
            dateOutpatientVisit,
            nameOrAddressOfOutpatientHealthFacilityVisited,

            participateInBurialrite,

            hadLabPositiveResult,
            dateLabPositiveResult,

            presentCondition,
            wherePatientDied,
            modeOfBurial
        );

        return form;
    }
}
