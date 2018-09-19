// 品牌服务
app.service("brandService", function ($http) {
    this.findAll = function () {
        return $http.get('../brand/findAll');
    };

    this.findPage = function (page,size) {
        return $http.get('../brand/findPage?page='+page +'&size='+size);
    };

    this.findOne = function (id) {
        return $http.get('../brand/findOne?id=' + id);
    };

    this.add = function (entity) {
        return $http.post('../brand/add', entity);
    };

    this.update = function (entity) {
        return $http.post('../brand/update', entity);
    };

    this.dele = function (ids) {
        return $http.get('../brand/delete?ids=' + ids);
    };

    this.search = function (page, size, searchEntity) {
        return $http.post('../brand/search?page=' + page +'&size=' + size, searchEntity);
    };

    //下拉列表数据
    this.selectOptionList=function(){
        return $http.get('../brand/selectOptionList');
    };
});