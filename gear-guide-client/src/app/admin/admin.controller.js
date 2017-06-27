export default class AdminController {
    constructor(adminService) {
        'ngInject';

        this.adminService = adminService;

        this.options = ['Gibson', 'Fender', 'Gretsch'];

        this.selection = [];

        this.player = {};
        this.guitar = {};
        this.amplifier = {};
    }

    createPlayer() {
        //TODO
    }

    createGuitar() {
        //TODO
    }

    createAmplifier() {
        //TODO
    }
}