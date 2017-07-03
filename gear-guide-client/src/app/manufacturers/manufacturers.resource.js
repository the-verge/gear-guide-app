export default ($resource, API_ROOT) => {
    'ngInject';

    return $resource(API_ROOT + 'manufacturers/:id', {id: '@id'}, {
        get: {
            method: 'get',
            timeout: 10000,
            isArray: true
        },

        getManufacturer: {
            url: API_ROOT + 'manufacturers/:id',
            method: 'get',
            timeout: 10000
        }
    });
};