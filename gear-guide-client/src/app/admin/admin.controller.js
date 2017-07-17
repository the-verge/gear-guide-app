export default class AdminController {
    constructor(adminService, toastr, PLAYER_INPUT, GUITAR_INPUT) {
        'ngInject';

        this.adminService = adminService;
        this.toastr = toastr;
        this.PLAYER_INPUT = PLAYER_INPUT;
        this.GUITAR_INPUT = GUITAR_INPUT;

        this.manufacturerOptions = this.adminService.getManufacturers();
        this.guitarOptions = this.getGuitars();
        this.amplifierOptions = this.getAmplifiers();
        this.effectOptions = ['One', 'Two'];

        this.player = {};
        this.guitar = {};
        this.amplifier = {};
    }

    getGuitars() {
        return this.adminService.getGuitars();
    }

    getAmplifiers() {
        return this.adminService.getAmplifiers();
    }

    createPlayer() {
        let formData = this.createFormData(this.player, this.PLAYER_INPUT);

        this.adminService.createPlayer(formData).then(() => {
            this.player = {};
            this.toastr.success('Player created successfully', 'Success');
        }, () => {
            this.toastr.error('Unable to create player', 'Error');
        });
    }

    createGuitar() {
        let formData = this.createFormData(this.guitar, this.GUITAR_INPUT);

        this.adminService.createGuitar(formData).then(() => {
            this.guitar = {};
            this.toastr.success('Guitar created successfully', 'Success');
            this.guitarOptions = this.getGuitars();
        }, () => {
            this.toastr.error('Unable to create guitar', 'Error');
        });
    }

    createFormData(entity, inputId) {
        let formData = new FormData();
        formData.append('details', JSON.stringify(entity));

        let image = this.getImage(inputId);
        formData.append('image', image);

        return formData;
    }

    getImage(inputId) {
        let input = document.getElementById(inputId);
        return input.files[0];
    }

    createAmplifier() {
        //TODO
    }
}
