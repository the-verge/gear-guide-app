export default class GuitarsService {
    constructor(guitarsResource) {
        'ngInject';

        this.guitarsResource = guitarsResource;
    }

    getGuitars() {
        return this.guitarsResource.get();
    }

    createGuitar(guitar) {
        return this.guitarsResource.create(guitar).$promise;
    }

}