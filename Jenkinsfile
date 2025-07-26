pipeline {
    agent any

    parameters {
        string(name: 'testNGSuite', defaultValue: '', description: 'Optional: TestNG XML file (e.g., testngThreadLocal.xml)')
        string(name: 'classes', defaultValue: '', description: 'Optional: Comma-separated list of test classes')
        choice(name: 'page', choices: ['All', 'Tasks.TestTask1', 'Tasks.TestTask2', 'Tasks.TestTask3', 'Tasks.TestTask4', 'Tasks.TestTask5'], description: 'Select a page to test')
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Run Selected Tests') {
            steps {
                script {
                    if (params.testNGSuite?.trim()) {
                        echo "Running TestNG suite: ${params.testNGSuite}"
                        sh "mvn clean test -DtestNGSuite=${params.testNGSuite}"
                    } else if (params.classes?.trim()) {
                        echo "Running multiple classes: ${params.classes}"
                        sh "mvn clean test -Dtest=${params.classes}"
                    } else if (params.page == 'All') {
                        echo "Running all tests"
                        sh "mvn clean test"
                    } else {
                        echo "Running single page: ${params.page}"
                        sh "mvn clean test -Dtest=${params.page}"
                    }
                }
            }
        }
    }
}
