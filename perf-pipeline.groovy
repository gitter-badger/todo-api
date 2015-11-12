stage "unit test"

node {
    git "https://github.com/brianvdawson/todo-api.git"
    sh "echo unit test app"
    //sh "mvn package"
}

checkpoint 'unit testing complete'

stage "prepare deployable"

build "freestyle-test"

checkpoint 'deployable ready'

stage "testing"
parallel "function test": {
        node {
            git "https://github.com/brianvdawson/todo-api.git"
            sh "echo run functional tests app"
        }
    },"performance test": {
            node {
                sh "echo performance test app"
            }
    }