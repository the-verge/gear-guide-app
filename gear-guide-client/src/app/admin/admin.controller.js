export default class AdminController {
    constructor(adminService, toastr, GUITAR) {
        'ngInject';

        this.adminService = adminService;
        this.toastr = toastr;
        this.GUITAR = GUITAR;

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
        let formData = new FormData();
        formData.append('details', JSON.stringify(this.guitar));

        let image = this.getImage(this.GUITAR);
        formData.append('image', image);

        this.adminService.createGuitar(formData).then(() => {
            this.guitar = {};
            this.toastr.success('Guitar created successfully', 'Success');
            this.guitarOptions = this.getGuitars();
        }, () => {
            this.toastr.error('Unable to create guitar', 'Error');
        });
    }

    getImage(inputId) {
        let input = document.getElementById(inputId);
        return input.files[0];
    }

    createAmplifier() {
        //TODO
    }
}
