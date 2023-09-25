import java.sql.SQLException;

public class Tester {
    public static void main(String[] args) {
        try {
            Brand ferrari = new Brand("Ferrari","Italy",1930);
            Brand mercedes = new Brand("Mercedes","Germany",1925);
            Brand audi = new Brand("Audi","Germany",1909);
            Brand lamborghini = new Brand("Lamborghini","Italy",1963);
            Brand suzuki = new Brand("Suzuki","Giappone",1909);
            Brand tesla = new Brand("Tesla","Stati Uniti",2003);
            Brand jaguar = new Brand("Jaguar","Regno Unito",1992);
            BrandDao brandDao = new BrandDao();
            //brandDao.createTable();
            Integer ferrariId = brandDao.insertBrand(ferrari);
            Integer mercedesId = brandDao.insertBrand(mercedes);
            Integer audiId = brandDao.insertBrand(audi);
            Integer lamborghiniId = brandDao.insertBrand(lamborghini);
            Integer suzukiId = brandDao.insertBrand(suzuki);
            Integer teslaId = brandDao.insertBrand(tesla);
            Integer jaguarId = brandDao.insertBrand(jaguar);
            Car portofino = new Car(ferrariId,"Portofino","Red",1989,150.000);
            Car purosangue = new Car(ferrariId,"Purosangue","Black",1999,10.000);
            Car  f90Stradale = new Car(ferrariId,"F90 Stradale","Yellow",2005,200.000);
            Car gle = new Car(mercedesId,"GLE","Grey",1989,130.000);
            Car classeA = new Car(mercedesId,"Classe A","Black",2010,90.000);
            Car amgGt = new Car(mercedesId,"AMG GT","Purple",2023,180.000);
            Car aTre = new Car(audiId,"A3","White",2018,50.000);
            Car qOtto = new Car(audiId,"Q8","Black",2023,80.000);
            Car rOtto = new Car(audiId,"R8","Blue",2022,220.000);
            Car aventador = new Car(lamborghiniId,"Aventador","Purple",2022,250.000);
            Car huracan = new Car(lamborghiniId,"Huracan","Orange",2023,290.000);
            Car urus = new Car(lamborghiniId,"Urus","Black",2022,300.000);
            Car swace = new Car(suzukiId,"Swace","White",2022,20.000);
            Car across = new Car(suzukiId,"Across","Red",2021,22.000);
            Car vitara = new Car(suzukiId,"Vitara","Orange",2019,18.000);
            Car modelY = new Car(teslaId,"Model Y","Orange",2019,50.000);
            Car modelX = new Car(teslaId,"Model X","Yellow",2020,130.000);
            Car modelS = new Car(teslaId,"Model S","Blue",2023,50.000);
            Car fPace = new Car(jaguarId,"F-PACE","Blue",2019,100.000);
            Car  xF = new Car(jaguarId,"XF","White",2018,80.000);
            Car ePace = new Car(jaguarId,"E-PACE","Blue",2017,60.000);
            CarDao carDao = new CarDao();
            //carDao.createTable();
            carDao.insertCar(portofino);
            carDao.insertCar(purosangue);
            carDao.insertCar(f90Stradale);
            carDao.insertCar(gle);
            carDao.insertCar(classeA);
            carDao.insertCar(amgGt);
            carDao.insertCar(aTre);
            carDao.insertCar(qOtto);
            carDao.insertCar(rOtto);
            carDao.insertCar(aventador);
            carDao.insertCar(huracan);
            carDao.insertCar(urus);
            carDao.insertCar(swace);
            carDao.insertCar(across);
            carDao.insertCar(vitara);
            carDao.insertCar(modelY);
            carDao.insertCar(modelX);
            carDao.insertCar(modelS);
            carDao.insertCar(fPace);
            carDao.insertCar(xF);
            carDao.insertCar(ePace);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}