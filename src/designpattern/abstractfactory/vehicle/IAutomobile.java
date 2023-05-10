package designpattern.abstractfactory.vehicle;

public interface IAutomobile {

    IHeadlight getHeadlight();
    ILogo getLogo();
    ISeat getSeat();
}
