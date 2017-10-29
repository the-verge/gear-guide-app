export default ($resource, API_ROOT) => {
    'ngInject';

    return $resource(API_ROOT + 'login/', {id: '@id'}, {
        login: {
            method: 'post',
            timeout: 10000
        }

    });
};