import unittest
import sys
sys.path.insert(1, '../')
from family import Family
from person import Person
import custom_exceptions

class TestPerson(unittest.TestCase):

    def setUp(self):
        self.person_1 = Person("person1","M")
        self.person_2 = Person("person2","F")
    def test_gender(self):
        self.assertEqual(self.person_1.gender, 'M')
        self.assertEqual(self.person_2.gender, "F")
    def test_name(self):
        self.assertEqual(self.person_1.name, "person1")
        self.assertEqual(self.person_2.name, "person2")
    def test_inadequate_information(self):
        with self.assertRaises(custom_exceptions.InadequateInformation):
            Person.get_brother(self.person_1)
if __name__=="__main__":
    unittest.main()