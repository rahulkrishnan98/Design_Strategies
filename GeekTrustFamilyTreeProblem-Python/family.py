from person import Person
import custom_exceptions
import constants

class Family:
    family_members = []
    def __init__(self, head):
        self.head = head
        self.family_members.append(head)
    
    def search_member(self, name):
        for member in (self.family_members):
            if(member.name ==  name):
                return member
        raise custom_exceptions.PersonNotFound(constants.PERSON_ERROR)
    

    '''
    Two ways to add members to family
    1) add_child
    2) add_spouse
    '''

    def add_child_in_family(self, mother, child):
        mother = Family.search_member(self, mother.name)
        mother.add_children(child)
        self.family_members.append(child)
    
   
    def add_spouse_in_family(self, member, spouse):
        member = Family.search_member(self,member.name)
        member.add_spouse(spouse)
        spouse.add_spouse(member)
        self.family_members.append(spouse)

    
    def get_relationship(self, member, relation):
        person = Family.search_member(self, member.name)

        if(relation == constants.SIBLINGS):
            result = Family.in_order(self,[sibling.name for sibling in person.get_brother()+ person.get_sister()])
        elif(relation == constants.PATERNAL_UNCLE):
            result = Family.in_order(self, [per.name for per in person.get_paternal_uncle()])
        elif(relation == constants.PATERNAL_AUNT):
            result = Family.in_order(self, [per.name for per in person.get_paternal_aunt()])
        elif(relation == constants.MATERNAL_UNCLE):
            result = Family.in_order(self, [per.name for per in person.get_maternal_uncle()])
        elif(relation == constants.MATERNAL_AUNT):
            result = Family.in_order(self, [per.name for per in person.get_maternal_aunt()])
        elif(relation == constants.COMMAND_SON):
            result = Family.in_order(self, [per.name for per in person.sons])
        elif(relation == constants.COMMAND_DAUGHTER):
            result = Family.in_order(self, [per.name for per in person.daughters])
        elif(relation == constants.SISTER_IN_LAW):
            result = Family.in_order(self, [inlaw.name for inlaw in person.get_sister_in_law()])
        elif(relation == constants.BROTHER_IN_LAW):
            result = Family.in_order(self, [inlaw.name for inlaw in person.get_brother_in_law()])
        else:
            raise custom_exceptions.CommandNotFound(constants.COMMAND_ERROR)
        if(len(result) == 0):
            raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        return result



    def in_order(self, arr):
        result = []
        arr = [Family.search_member(self, arr[i]) for i in range(len(arr))]
        members = self.family_members
        for member in members:
            if(member in arr):
                result.append(member)
        result = [person.name for person in result]
        return result