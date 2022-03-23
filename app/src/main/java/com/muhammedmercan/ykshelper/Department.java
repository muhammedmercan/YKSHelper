package com.muhammedmercan.ykshelper;


public class Department {

    private String university;
    private String faculty;
    private String department;
    private String city;
    private String typeOfPoint;
    private String conditions;
    private String additionalInfo;
    private String educationTime;
    private String associate_degree;
    private String typeOfUniversity;
    private String quota2021;
    private String quota2020;
    private String quota2019;
    private String quota2018;
    private String quota2017;
    private String quota2016;
    private String quota2015;
    private String winner2021;
    private String winner2020;
    private String winner2019;
    private String winner2018;
    private String placementPoint2021;
    private String placementPoint2020;
    private String placementPoint2019;
    private String placementPoint2018;
    private String placementPoint2017;
    private String placementPoint2016;
    private String placementPoint2015;
    private String additionalQuota2020;
    private String additionalQuota2019;
    private String additionalQuota2018;
    private String firstWinner2021;
    private String firstWinner2020;
    private String firstWinner2019;
    private String firstWinner2018;
    private String maxPoint2021;
    private String maxPoint2020;
    private String firstWinnerPlacementRanking2021;
    private String firstWinnerPlacementRanking2020;
    private String firstWinnerPlacementRanking2018;
    private String firstWinnerPlacementPoint2021;
    private String firstWinnerPlacementPoint2020;
    private String firstWinnerMaxPoint2021;
    private String firstWinnerMaxPoint2020;
    private String minPoint2018;
    private String prefence2017;
    private String prefence2016;
    private String prefenceTotal2020;
    private String prefenceTotal2018;
    private String prefenceTop1_2020;
    private String prefenceTop1_2018;
    private String prefenceTop1_2017;
    private String prefenceTop1_2016;
    private String prefenceTop3_2020;
    private String prefenceTop3_2018;
    private String prefenceTop3_2017;
    private String prefenceTop3_2016;
    private String prefenceTop9_2020;
    private String prefenceTop9_2018;
    private String prefenceTop9_2017;
    private String prefenceTop9_2016;
    private String man2020;
    private String man2019;
    private String man2018;
    private String girl2020;
    private String girl2019;
    private String girl2018;
    private String highSchool2020;
    private String highSchool2019;
    private String highSchool2018;
    private String graduate2020;
    private String graduate2019;
    private String graduate2018;
    private String collageStudent2020;
    private String collageStudent2019;
    private String collageStudent2018;
    private String graduateFromUniverstiy2020;
    private String graduateFromUniverstiy2019;
    private String graduateFromUniverstiy2018;
    private String tytPlacementPoint2018;
    private String tytPlacementRanking2018;


    private int id, placementRanking2021, placementRanking2020, placementRanking2019, placementRanking2018, placementRanking2017,placementRanking2016,placementRanking2015;


    public Department(int id, String university, String faculty, String department, String city, String typeOfPoint, String conditions, String additionalInfo,
                      String educationTime, String associate_degree, String typeOfUniversity, String quota2021, String quota2020, String quota2019,
                      String quota2018, String quota2017, String quota2016, String quota2015, String winner2021, String winner2020, String winner2019,
                      String winner2018, int placementRanking2021, int placementRanking2020, int placementRanking2019, int placementRanking2018,
                      int placementRanking2017, int placementRanking2016,
                      int placementRanking2015, String placementPoint2021, String placementPoint2020, String placementPoint2019, String placementPoint2018,
                      String placementPoint2017, String placementPoint2016, String placementPoint2015, String additionalQuota2020, String additionalQuota2019,
                      String additionalQuota2018, String firstWinner2021, String firstWinner2020, String firstWinner2019, String firstWinner2018,
                      String maxPoint2021, String maxPoint2020, String firstWinnerPlacementRanking2021, String firstWinnerPlacementRanking2020,
                      String firstWinnerPlacementRanking2018, String firstWinnerPlacementPoint2021, String firstWinnerPlacementPoint2020,
                      String firstWinnerMaxPoint2021, String firstWinnerMaxPoint2020, String minPoint2018, String prefence2017, String prefence2016,
                      String prefenceTotal2020, String prefenceTotal2018, String prefenceTop1_2020, String prefenceTop1_2018, String prefenceTop1_2017,
                      String prefenceTop1_2016, String prefenceTop3_2020, String prefenceTop3_2018, String prefenceTop3_2017, String prefenceTop3_2016,
                      String prefenceTop9_2020, String prefenceTop9_2018, String prefenceTop9_2017, String prefenceTop9_2016, String man2020,
                      String man2019, String man2018, String girl2020, String girl2019, String girl2018, String highSchool2020, String highSchool2019,
                      String highSchool2018, String graduate2020, String graduate2019, String graduate2018, String collageStudent2020,
                      String collageStudent2019, String collageStudent2018, String graduateFromUniverstiy2020, String graduateFromUniverstiy2019,
                      String graduateFromUniverstiy2018, String tytPlacementPoint2018, String tytPlacementRanking2018) {
        this.university = university;
        this.faculty = faculty;
        this.department = department;
        this.city = city;
        this.typeOfPoint = typeOfPoint;
        this.conditions = conditions;
        this.additionalInfo = additionalInfo;
        this.educationTime = educationTime;
        this.associate_degree = associate_degree;
        this.typeOfUniversity = typeOfUniversity;
        this.quota2021 = quota2021;
        this.quota2020 = quota2020;
        this.quota2019 = quota2019;
        this.quota2018 = quota2018;
        this.quota2017 = quota2017;
        this.quota2016 = quota2016;
        this.quota2015 = quota2015;
        this.winner2021 = winner2021;
        this.winner2020 = winner2020;
        this.winner2019 = winner2019;
        this.winner2018 = winner2018;
        this.placementPoint2021 = placementPoint2021;
        this.placementPoint2020 = placementPoint2020;
        this.placementPoint2019 = placementPoint2019;
        this.placementPoint2018 = placementPoint2018;
        this.placementPoint2017 = placementPoint2017;
        this.placementPoint2016 = placementPoint2016;
        this.placementPoint2015 = placementPoint2015;
        this.additionalQuota2020 = additionalQuota2020;
        this.additionalQuota2019 = additionalQuota2019;
        this.additionalQuota2018 = additionalQuota2018;
        this.firstWinner2021 = firstWinner2021;
        this.firstWinner2020 = firstWinner2020;
        this.firstWinner2019 = firstWinner2019;
        this.firstWinner2018 = firstWinner2018;
        this.maxPoint2021 = maxPoint2021;
        this.maxPoint2020 = maxPoint2020;
        this.firstWinnerPlacementRanking2021 = firstWinnerPlacementRanking2021;
        this.firstWinnerPlacementRanking2020 = firstWinnerPlacementRanking2020;
        this.firstWinnerPlacementRanking2018 = firstWinnerPlacementRanking2018;
        this.firstWinnerPlacementPoint2021 = firstWinnerPlacementPoint2021;
        this.firstWinnerPlacementPoint2020 = firstWinnerPlacementPoint2020;
        this.firstWinnerMaxPoint2021 = firstWinnerMaxPoint2021;
        this.firstWinnerMaxPoint2020 = firstWinnerMaxPoint2020;
        this.minPoint2018 = minPoint2018;
        this.prefence2017 = prefence2017;
        this.prefence2016 = prefence2016;
        this.prefenceTotal2020 = prefenceTotal2020;
        this.prefenceTotal2018 = prefenceTotal2018;
        this.prefenceTop1_2020 = prefenceTop1_2020;
        this.prefenceTop1_2018 = prefenceTop1_2018;
        this.prefenceTop1_2017 = prefenceTop1_2017;
        this.prefenceTop1_2016 = prefenceTop1_2016;
        this.prefenceTop3_2020 = prefenceTop3_2020;
        this.prefenceTop3_2018 = prefenceTop3_2018;
        this.prefenceTop3_2017 = prefenceTop3_2017;
        this.prefenceTop3_2016 = prefenceTop3_2016;
        this.prefenceTop9_2020 = prefenceTop9_2020;
        this.prefenceTop9_2018 = prefenceTop9_2018;
        this.prefenceTop9_2017 = prefenceTop9_2017;
        this.prefenceTop9_2016 = prefenceTop9_2016;
        this.man2020 = man2020;
        this.man2019 = man2019;
        this.man2018 = man2018;
        this.girl2020 = girl2020;
        this.girl2019 = girl2019;
        this.girl2018 = girl2018;
        this.highSchool2020 = highSchool2020;
        this.highSchool2019 = highSchool2019;
        this.highSchool2018 = highSchool2018;
        this.graduate2020 = graduate2020;
        this.graduate2019 = graduate2019;
        this.graduate2018 = graduate2018;
        this.collageStudent2020 = collageStudent2020;
        this.collageStudent2019 = collageStudent2019;
        this.collageStudent2018 = collageStudent2018;
        this.graduateFromUniverstiy2020 = graduateFromUniverstiy2020;
        this.graduateFromUniverstiy2019 = graduateFromUniverstiy2019;
        this.graduateFromUniverstiy2018 = graduateFromUniverstiy2018;
        this.tytPlacementPoint2018 = tytPlacementPoint2018;
        this.tytPlacementRanking2018 = tytPlacementRanking2018;
        this.id = id;
        this.placementRanking2021 = placementRanking2021;
        this.placementRanking2020 = placementRanking2020;
        this.placementRanking2019 = placementRanking2019;
        this.placementRanking2018 = placementRanking2018;
        this.placementRanking2017 = placementRanking2017;
        this.placementRanking2016 = placementRanking2016;
        this.placementRanking2015 = placementRanking2015;
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

    public String getEducationTime() {
        return educationTime;
    }

    public void setEducationTime(String educationTime) {
        this.educationTime = educationTime;
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
                "university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                ", typeOfPoint='" + typeOfPoint + '\'' +
                ", conditions='" + conditions + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", educationTime='" + educationTime + '\'' +
                ", associate_degree='" + associate_degree + '\'' +
                ", typeOfUniversity='" + typeOfUniversity + '\'' +
                ", quota2021='" + quota2021 + '\'' +
                ", quota2020='" + quota2020 + '\'' +
                ", quota2019='" + quota2019 + '\'' +
                ", quota2018='" + quota2018 + '\'' +
                ", quota2017='" + quota2017 + '\'' +
                ", quota2016='" + quota2016 + '\'' +
                ", quota2015='" + quota2015 + '\'' +
                ", winner2021='" + winner2021 + '\'' +
                ", winner2020='" + winner2020 + '\'' +
                ", winner2019='" + winner2019 + '\'' +
                ", winner2018='" + winner2018 + '\'' +
                ", placementPoint2021='" + placementPoint2021 + '\'' +
                ", placementPoint2020='" + placementPoint2020 + '\'' +
                ", placementPoint2019='" + placementPoint2019 + '\'' +
                ", placementPoint2018='" + placementPoint2018 + '\'' +
                ", placementPoint2017='" + placementPoint2017 + '\'' +
                ", placementPoint2016='" + placementPoint2016 + '\'' +
                ", placementPoint2015='" + placementPoint2015 + '\'' +
                ", additionalQuota2020='" + additionalQuota2020 + '\'' +
                ", additionalQuota2019='" + additionalQuota2019 + '\'' +
                ", additionalQuota2018='" + additionalQuota2018 + '\'' +
                ", firstWinner2021='" + firstWinner2021 + '\'' +
                ", firstWinner2020='" + firstWinner2020 + '\'' +
                ", firstWinner2019='" + firstWinner2019 + '\'' +
                ", firstWinner2018='" + firstWinner2018 + '\'' +
                ", maxPoint2021='" + maxPoint2021 + '\'' +
                ", maxPoint2020='" + maxPoint2020 + '\'' +
                ", firstWinnerPlacementRanking2021='" + firstWinnerPlacementRanking2021 + '\'' +
                ", firstWinnerPlacementRanking2020='" + firstWinnerPlacementRanking2020 + '\'' +
                ", firstWinnerPlacementRanking2018='" + firstWinnerPlacementRanking2018 + '\'' +
                ", firstWinnerPlacementPoint2021='" + firstWinnerPlacementPoint2021 + '\'' +
                ", firstWinnerPlacementPoint2020='" + firstWinnerPlacementPoint2020 + '\'' +
                ", firstWinnerMaxPoint2021='" + firstWinnerMaxPoint2021 + '\'' +
                ", firstWinnerMaxPoint2020='" + firstWinnerMaxPoint2020 + '\'' +
                ", minPoint2018='" + minPoint2018 + '\'' +
                ", prefence2017='" + prefence2017 + '\'' +
                ", prefence2016='" + prefence2016 + '\'' +
                ", prefenceTotal2020='" + prefenceTotal2020 + '\'' +
                ", prefenceTotal2018='" + prefenceTotal2018 + '\'' +
                ", prefenceTop1_2020='" + prefenceTop1_2020 + '\'' +
                ", prefenceTop1_2018='" + prefenceTop1_2018 + '\'' +
                ", prefenceTop1_2017='" + prefenceTop1_2017 + '\'' +
                ", prefenceTop1_2016='" + prefenceTop1_2016 + '\'' +
                ", prefenceTop3_2020='" + prefenceTop3_2020 + '\'' +
                ", prefenceTop3_2018='" + prefenceTop3_2018 + '\'' +
                ", prefenceTop3_2017='" + prefenceTop3_2017 + '\'' +
                ", prefenceTop3_2016='" + prefenceTop3_2016 + '\'' +
                ", prefenceTop9_2020='" + prefenceTop9_2020 + '\'' +
                ", prefenceTop9_2018='" + prefenceTop9_2018 + '\'' +
                ", prefenceTop9_2017='" + prefenceTop9_2017 + '\'' +
                ", prefenceTop9_2016='" + prefenceTop9_2016 + '\'' +
                ", man2020='" + man2020 + '\'' +
                ", man2019='" + man2019 + '\'' +
                ", man2018='" + man2018 + '\'' +
                ", girl2020='" + girl2020 + '\'' +
                ", girl2019='" + girl2019 + '\'' +
                ", girl2018='" + girl2018 + '\'' +
                ", highSchool2020='" + highSchool2020 + '\'' +
                ", highSchool2019='" + highSchool2019 + '\'' +
                ", highSchool2018='" + highSchool2018 + '\'' +
                ", graduate2020='" + graduate2020 + '\'' +
                ", graduate2019='" + graduate2019 + '\'' +
                ", graduate2018='" + graduate2018 + '\'' +
                ", collageStudent2020='" + collageStudent2020 + '\'' +
                ", collageStudent2019='" + collageStudent2019 + '\'' +
                ", collageStudent2018='" + collageStudent2018 + '\'' +
                ", graduateFromUniverstiy2020='" + graduateFromUniverstiy2020 + '\'' +
                ", graduateFromUniverstiy2019='" + graduateFromUniverstiy2019 + '\'' +
                ", graduateFromUniverstiy2018='" + graduateFromUniverstiy2018 + '\'' +
                ", tytPlacementPoint2018='" + tytPlacementPoint2018 + '\'' +
                ", tytPlacementRanking2018='" + tytPlacementRanking2018 + '\'' +
                ", id=" + id +
                ", placementRanking2021=" + placementRanking2021 +
                ", placementRanking2020=" + placementRanking2020 +
                ", placementRanking2019=" + placementRanking2019 +
                ", placementRanking2018=" + placementRanking2018 +
                ", placementRanking2017=" + placementRanking2017 +
                ", placementRanking2016=" + placementRanking2016 +
                ", placementRanking2015=" + placementRanking2015 +
                '}';
    }
}