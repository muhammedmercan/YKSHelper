package com.muhammedmercan.ykshelper;

import java.util.ArrayList;

public class Department {

    private String typeOfPoint, university, faculty, department, additionalInfo, city,  typeOfUniversity, typeOfDepartment,
    typeOfDepartment2, quota2021,  quota2020,  quota2019, quota2018, status, winner2021, winner2020, winner2019, winner2018,  placementPoint2021,
    placementPoint2020, placementPoint2019,  placementPoint2018;

    private int id, placementRanking2021, placementRanking2020, placementRanking2019, placementRanking2018;


    public Department(int id,String university, String faculty, String department, String language, String typeOfPoint,
                      String additionalInfo, String educationTime, String city, String typeOfUniversity,
                      String typeOfDepartment, String typeOfDepartment2, String quota2021, String quota2020, String quota2019,
                      String quota2018, String status, String winner2021, String winner2020, String winner2019, String winner2018,
                      int placementRanking2021, int placementRanking2020, int placementRanking2019, int placementRanking2018,
                      String placementPoint2021, String placementPoint2020, String placementPoint2019, String placementPoint2018) {
        this.id = id;
        this.typeOfPoint = typeOfPoint;
        this.university = university;
        this.faculty = faculty;
        this.department = department;
        this.additionalInfo = additionalInfo;
        this.city = city;
        this.typeOfUniversity = typeOfUniversity;
        this.typeOfDepartment = typeOfDepartment;
        this.typeOfDepartment2 = typeOfDepartment2;
        this.quota2021 = quota2021;
        this.quota2020 = quota2020;
        this.quota2019 = quota2019;
        this.quota2018 = quota2018;
        this.status = status;
        this.winner2021 = winner2021;
        this.winner2020 = winner2020;
        this.winner2019 = winner2019;
        this.winner2018 = winner2018;
        this.placementRanking2021 = placementRanking2021;
        this.placementRanking2020 = placementRanking2020;
        this.placementRanking2019 = placementRanking2019;
        this.placementRanking2018 = placementRanking2018;
        this.placementPoint2021 = placementPoint2021;
        this.placementPoint2020 = placementPoint2020;
        this.placementPoint2019 = placementPoint2019;
        this.placementPoint2018 = placementPoint2018;
        ;
    }

    public String getTypeOfPoint() {
        return typeOfPoint;
    }

    public void setTypeOfPoint(String typeOfPoint) {
        this.typeOfPoint = typeOfPoint;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTypeOfUniversity() {
        return typeOfUniversity;
    }

    public void setTypeOfUniversity(String typeOfUniversity) {
        this.typeOfUniversity = typeOfUniversity;
    }

    public String getTypeOfDepartment() {
        return typeOfDepartment;
    }

    public void setTypeOfDepartment(String typeOfDepartment) {
        this.typeOfDepartment = typeOfDepartment;
    }

    public String getTypeOfDepartment2() {
        return typeOfDepartment2;
    }

    public void setTypeOfDepartment2(String typeOfDepartment2) {
        this.typeOfDepartment2 = typeOfDepartment2;
    }

    public String getQuota2021() {
        return quota2021;
    }

    public void setQuota2021(String quota2021) {
        this.quota2021 = quota2021;
    }

    public String getQuota2020() {
        return quota2020;
    }

    public void setQuota2020(String quota2020) {
        this.quota2020 = quota2020;
    }

    public String getQuota2019() {
        return quota2019;
    }

    public void setQuota2019(String quota2019) {
        this.quota2019 = quota2019;
    }

    public String getQuota2018() {
        return quota2018;
    }

    public void setQuota2018(String quota2018) {
        this.quota2018 = quota2018;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWinner2021() {
        return winner2021;
    }

    public void setWinner2021(String winner2021) {
        this.winner2021 = winner2021;
    }

    public String getWinner2020() {
        return winner2020;
    }

    public void setWinner2020(String winner2020) {
        this.winner2020 = winner2020;
    }

    public String getWinner2019() {
        return winner2019;
    }

    public void setWinner2019(String winner2019) {
        this.winner2019 = winner2019;
    }

    public String getWinner2018() {
        return winner2018;
    }

    public void setWinner2018(String winner2018) {
        this.winner2018 = winner2018;
    }

    public String getPlacementPoint2021() {
        return placementPoint2021;
    }

    public void setPlacementPoint2021(String placementPoint2021) {
        this.placementPoint2021 = placementPoint2021;
    }

    public String getPlacementPoint2020() {
        return placementPoint2020;
    }

    public void setPlacementPoint2020(String placementPoint2020) {
        this.placementPoint2020 = placementPoint2020;
    }

    public String getPlacementPoint2019() {
        return placementPoint2019;
    }

    public void setPlacementPoint2019(String placementPoint2019) {
        this.placementPoint2019 = placementPoint2019;
    }

    public String getPlacementPoint2018() {
        return placementPoint2018;
    }

    public void setPlacementPoint2018(String placementPoint2018) {
        this.placementPoint2018 = placementPoint2018;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlacementRanking2021() {
        return placementRanking2021;
    }

    public void setPlacementRanking2021(int placementRanking2021) {
        this.placementRanking2021 = placementRanking2021;
    }

    public int getPlacementRanking2020() {
        return placementRanking2020;
    }

    public void setPlacementRanking2020(int placementRanking2020) {
        this.placementRanking2020 = placementRanking2020;
    }

    public int getPlacementRanking2019() {
        return placementRanking2019;
    }

    public void setPlacementRanking2019(int placementRanking2019) {
        this.placementRanking2019 = placementRanking2019;
    }

    public int getPlacementRanking2018() {
        return placementRanking2018;
    }

    public void setPlacementRanking2018(int placementRanking2018) {
        this.placementRanking2018 = placementRanking2018;
    }

    @Override
    public String toString() {
        return "Department{" +
                "typeOfPoint='" + typeOfPoint + '\'' +
                ", university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", department='" + department + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", city='" + city + '\'' +
                ", typeOfUniversity='" + typeOfUniversity + '\'' +
                ", typeOfDepartment='" + typeOfDepartment + '\'' +
                ", typeOfDepartment2='" + typeOfDepartment2 + '\'' +
                ", quota2021='" + quota2021 + '\'' +
                ", quota2020='" + quota2020 + '\'' +
                ", quota2019='" + quota2019 + '\'' +
                ", quota2018='" + quota2018 + '\'' +
                ", status='" + status + '\'' +
                ", winner2021='" + winner2021 + '\'' +
                ", winner2020='" + winner2020 + '\'' +
                ", winner2019='" + winner2019 + '\'' +
                ", winner2018='" + winner2018 + '\'' +
                ", placementPoint2021='" + placementPoint2021 + '\'' +
                ", placementPoint2020='" + placementPoint2020 + '\'' +
                ", placementPoint2019='" + placementPoint2019 + '\'' +
                ", placementPoint2018='" + placementPoint2018 + '\'' +
                ", id=" + id +
                ", placementRanking2021=" + placementRanking2021 +
                ", placementRanking2020=" + placementRanking2020 +
                ", placementRanking2019=" + placementRanking2019 +
                ", placementRanking2018=" + placementRanking2018 +
                '}';
    }
}
