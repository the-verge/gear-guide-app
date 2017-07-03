export default class AdminController {
    constructor(adminService, toastr) {
        'ngInject';

        this.adminService = adminService;
        this.toastr = toastr;

        this.options = ['One', 'Two'];

        this.manufacturerOptions = this.adminService.getManufacturers();
        this.guitarOptions = this.getGuitars();

        this.player = {};
        this.guitar = {};
        this.amplifier = {};
    }

    getGuitars() {
        return this.adminService.getGuitars();
    }

    createPlayer() {
        //TODO
    }

    createGuitar() {
        this.adminService.createGuitar(this.guitar).then(() => {
            this.guitar = {};
            this.toastr.success('Guitar created successfully', 'Success');
            this.guitarOptions = this.getGuitars();
        }, () => {
            this.toastr.error('Unable to create guitar', 'Error');
        });
    }

    createAmplifier() {
        //TODO
    }
}
