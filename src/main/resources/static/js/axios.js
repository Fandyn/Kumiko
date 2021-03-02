var Main = {

    mounted (){
        let that = this;
        axios.post('/axios/queryUserList', {sex: null})
            .then(function (response) {
                // that.tableData = response.data.list;
                that.total = response.data.total;
                that.handleSizeChange(that.pageSize);
            }, function (err) {
                that.info = err;
            })
    },

    methods: {

        tableRowClassName({row, rowIndex}) {
            var i = rowIndex;
           //四个一组，筛选奇数，一三各不同
            //天命既定
            //星命定轨
            if (i % 2 == 1) {
                if (i % 3 != 0) {
                    return 'warning-row';
                } else {
                    return 'success-row';
                }
            }
            return '';
        },

        //element似乎只能使用这种格式的方法>v<(误)
        //包子。。。
        onSubmit() {
            let that = this;
            axios.post('/axios/queryUserList', {sex: that.formInline.sex})
                .then(function (response) {
                    // that.tableData = response.data.list;
                    that.total = response.data.total;
                    that.pageNum = 1;
                    that.handleSizeChange(that.pageSize);
                }, function (err) {
                    that.info = err;
                })
        },

        onSubmitid() {
            let that = this;
            axios.post('/axios/queryUserListByterm', {id: that.formInline.userid,sex: that.formInline.sex})
                .then(function (response) {
                    // that.tableData = response.data.list;
                    that.total = response.data.total;
                    that.pageNum = 1;
                    that.handleSizeChange(that.pageSize);
                }, function (err) {
                    that.info = err;
                })
        },

        fun() {
            let that = this;
            this.onSubmitid();
        },

        handleSizeChange(val) {
            //每页条数
            let that = this;
            this.pageSize = val;
            axios.post('/axios/queryinfo', {id: that.formInline.userid,sex: that.formInline.sex,pageSize:val,pageNum:that.pageNum})
                .then(function (response) {
                    //num size
                    //3 5 - 3 10 ==2 5
                    //8 2 - 8 3 == 5 2
                    //组件自动将最大页码设置好了
                    that.tableData = response.data.list;
                }, function (err) {
                    that.info = err;
                })
            console.log(`每页 ${val} 条`);
        },

        handleCurrentChange(val) {
            //当前页数
            let that = this;
            this.pageNum = val;
            axios.post('/axios/queryinfo', {id: that.formInline.userid,sex: that.formInline.sex,pageSize:that.pageSize,pageNum:val})
                .then(function (response) {
                    that.tableData = response.data.list;
                }, function (err) {
                    that.info = err;
                })
            console.log(`当前页: ${val}`);
        },

        handleClick(row) {
            this.info = row;
        },

        handleClickdel(row) {
            //删除用户
            let that = this;
            // { "id": 45, "username": "传智播客", "birthday": "2018-03-04T12:04:06", "sex": "男", "address": "北京金燕龙", "pageSize": 0, "pageNum": 0 }
            axios.post('/axios/delUser', {id: row.id,username:row.username,birthday:row.birthday,sex:row.sex,address:row.address})
                .then(function (response) {
                    that.info = row;
                    that.total -= 1;
                    that.handleSizeChange(that.pageSize);
                }, function (err) {
                    that.info = err;
                })
        },

        handleClickup(row) {
            this.form.username = row.username;
            this.form.address = row.address;
            this.form.birthday = row.birthday;
            this.form.id = row.id;
            this.form.sex = row.sex;
            this.add_up = "updata";
            this.dialogupdata = true;
        },

        handleClickadd() {
            this.add_up = "addUser";
            this.dialog = true;
        },

        handleClose(done) {
            if (this.loading) {
                return;
            }
            this.$confirm('确定要提交表单吗？')
                .then(_ => {
                    this.loading = true;
                    this.timer = setTimeout(() => {
                        done();
                        // 动画关闭需要一定的时间
                        setTimeout(() => {
                            this.loading = false;
                        }, 400);
                        console.log("可乐"+"--"+this.form.username+"--"+this.form.sex);//动画过后执行
                        //添加方法
                        if (this.add_up=="addUser") {
                            {
                                let that = this;
                                axios.post('/axios/addUser', {
                                    id: that.form.id,
                                    username: that.form.username,
                                    birthday: that.form.birthday,
                                    sex: that.form.sex,
                                    address: that.form.address
                                })
                                    .then(function (response) {
                                        that.info = that.form;
                                        //页面刷新
                                        that.total += 1;
                                        that.handleSizeChange(that.pageSize);
                                    }, function (err) {
                                        that.info = err;
                                    });
                                this.dialog = false;
                            }
                            console.log("addUser");
                        }else {
                            {
                                //修改方法
                                let that = this;
                                axios.post('/axios/updateUser', {
                                    id: that.form.id,
                                    username: that.form.username,
                                    birthday: that.form.birthday,
                                    sex: that.form.sex,
                                    address: that.form.address
                                })
                                    .then(function (response) {
                                        that.info = that.form;
                                        //页面刷新
                                        that.handleSizeChange(that.pageSize);
                                    }, function (err) {
                                        that.info = err;
                                    })
                            }
                            console.log("updata");
                        }
                    }, 2000);
                    console.log("刻晴");//动画之前执行
                })
                .catch(_ => {});
            // console.log("默然");
        },

        cancelForm() {
            this.loading = false;
            this.dialog = false;
            this.dialogupdata = false;
            clearTimeout(this.timer);
            console.log("关闭");
        }
    },

    data() {
        return {
            add_up:"",
            dialog: false,
            dialogupdata:false,
            loading: false,
            info:'this is test',
            pageSize:5,
            pageNum:1,
            total:"",
            formInline: {
                userid: '',
                sex: ''
            },
            tableData: [],
            form: {
                username: '',
                sex: '',
                address:'',
                id:'',
                birthday:'',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            timer: null,
        }
    }

}
var Ctor = Vue.extend(Main)
// $mount手动挂载
new Ctor().$mount('#app')
