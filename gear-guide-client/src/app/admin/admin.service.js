export default class AdminService {
    constructor(playersService, guitarsService, amplifiersService, manufacturersService) {
        'ngInject';

        this.playersService = playersService;
        this.guitarsService = guitarsService;
        this.amplifiersService = amplifiersService;
        this.manufacturersService = manufacturersService;
    }

    getGuitars() {
        return this.guitarsService.getGuitars();
    }

    getAmplifiers() {
        return this.amplifiersService.getAmplifiers();
    }

    getManufacturers() {
        return this.manufacturersService.getManufacturers();
    }

    createGuitar(guitar) {
        return this.guitarsService.createGuitar(guitar);
    }
}