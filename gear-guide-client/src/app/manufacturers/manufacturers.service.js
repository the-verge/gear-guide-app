export default class ManufacturersService {
    constructor(manufacturersResource) {
        'ngInject';

        this.manufacturersResource = manufacturersResource;
    }

    getManufacturers() {
        return this.manufacturersResource.get();
    }
}